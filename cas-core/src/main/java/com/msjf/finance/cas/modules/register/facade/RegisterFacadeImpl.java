package com.msjf.finance.cas.modules.register.facade;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.register.RegisterFacade;
import com.msjf.finance.cas.modules.Account;
import com.msjf.finance.cas.modules.ausAuthone.dao.AusAuthoneDao;
import com.msjf.finance.cas.modules.ausAuthone.entity.AusAuthoneEntity;
import com.msjf.finance.cas.modules.organ.dao.OrganInfoChangeDao;
import com.msjf.finance.cas.modules.organ.dao.OrganInfoDao;
import com.msjf.finance.cas.modules.organ.entity.OrganInfoEntity;
import com.msjf.finance.cas.modules.organRollin.dao.OrganRollinDao;
import com.msjf.finance.cas.modules.organRollin.entity.OrganRollinEntity;
import com.msjf.finance.cas.modules.person.dao.PersonInfoDao;
import com.msjf.finance.cas.modules.person.entity.PersonInfoEntity;
import com.msjf.finance.cas.modules.register.dao.CasRegisterDao;
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.dao.RegisterDao;
import com.msjf.finance.cas.modules.register.entity.CasRegisterInfoEntity;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务用户注册
 * Created by lzp on 2018/12/25.
 */
@Service("registerFacade")
@Transactional(propagation=Propagation.REQUIRED)
public class RegisterFacadeImpl extends Account implements RegisterFacade{

    @Resource
    CustDao custDao;

    @Resource
    OrganInfoDao organInfoDao;

    @Resource
    OrganInfoChangeDao organInfoChangeDao;

    @Resource
    OrganRollinDao organRollinDao;

    @Resource
    PersonInfoDao personInfoDao;

    @Resource
    AusAuthoneDao  ausAuthoneDao;


    @Resource
    CasRegisterDao casRegisterDao;

    /**
     * 用户类型
     */
    private String membertype;

    /**
     * 注册来源 0-web 1-app
     */
    private String registersource;



    /**
     * 用户名称
     */
    private String membername;

    /**
     * 证件类型 0-身份证 1-护照 A-营业执照
     */
    private String certificatetype;

    /**
     * 证件号码
     */
    private String certificateno;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 银行卡号
     */
    private String cardno;

    /**
     * 银行
     */
    private String bank;

    /**
     * 验证码
     */
    private String msgcode;

    /**
     * 密码
     */
    private String password;


    /**
     * 就职单位
     */
    private String companyname;

    /**
     * 法人名称
     */
    private String corname;


    /**
     * 法人证件类型
     */
    private String corcardtype;


    /**
     * 法人证件号码
     */
    private String corcardno;


    /**
     * 法注册步骤
     */
    private String step;



    /**
     * 客户代码
     */
    private String customerno;

    /**
     * apply表申请流水号
     */
    private String appSerialno;

    /**
     * 认证表申请流水号
     */
    private String authSerialno;

    ADEncrypUtil aDEncryp = new ADEncrypUtil();
    ParseSystemUtil parseSystemUtil = new ParseSystemUtil();


    public Response<List<Map<String, String>>> inserRegister(HashMap<String, Object> mapParam) {

        try{
            getParam(mapParam);//获取入参
            preCheck();//入参校验

            if(step.equals(step_1)){
                if (membertype.equals(company)) {
                    /**
                     * 1、企业名称以及企业营业执照校验
                     * 2、校验成功后生成custno并记录相关数据
                     */
                    //企业名称唯一检查
                    checkOrganName();
                    checkCustCertificateno(); //证件号在cust表校验唯一性
                }else if(membertype.equals(person)){
                    /**
                     * 1、先做手机验证码校验；
                     * 2、校验成功生成custno并记录手机号码
                     */
                    checkCustMembertypeAndMobile();//用户类型+手机号码在cust表校验唯一性
                    checkCustMembertypeAndMobile();
                }
                String  id =  StringUtil.getUUID();//生成
                addCasRegisterInfo(id);//写用户注册基本信息表
            }else if(step.equals(step_2)){
                if (membertype.equals(company)) {
                    /**
                     * 需校验验证码
                     */
                }
                Map<String,Object> entity = new HashMap<>();
                entity = getCasRegister();
                if(ObjectUtils.isEmpty(entity)){
                    return new Response<>().fail();
                }
                mapParam.put("id",entity.get("id"));
                updCasRegisterInfo(mapParam);
            }else if(step.equals(step_3)){
                Map<String,Object> entity = new HashMap<>();
                entity = getCasRegister();
                if(ObjectUtils.isEmpty(entity)){
                    return new Response<>().fail();
                }
                addCust(entity);
                if (membertype.equals(company)) {
                addOrganInfo(entity);
                }else{
                addPersonInfo(entity);
                }
                addAuthone(entity);
            }
/*

            appSerialno = DateUtil.getUserDate(DATE_FMT_DATE + DATE_FMT_TIME) + CommonUtil.getRandomCode(1, 6);

            if (membertype.equals(person)) {//个人
                addPersonInfo();
            } else {//企业
                addOrganInfo();
            }
            */
        }catch (Exception e){
            return new Response<>().fail();
        }
        return null;
    }

    /**
     * 获取入参
     * @param mapParam
     */
    private void getParam(HashMap<String, Object> mapParam) {
        membertype = StringUtil.valueOf(mapParam.get("membertype"));
        registersource = StringUtil.valueOf(mapParam.get("registersource"));
        membername = StringUtil.valueOf(mapParam.get("membername"));
        certificatetype = StringUtil.valueOf(mapParam.get("certificatetype"));
        certificateno = StringUtil.valueOf(mapParam.get("certificateno"));
        mobile = StringUtil.valueOf(mapParam.get("mobile"));
        cardno = StringUtil.valueOf(mapParam.get("cardno"));
        bank = StringUtil.valueOf(mapParam.get("bank"));
        msgcode = StringUtil.valueOf(mapParam.get("msgcode"));
        password = StringUtil.valueOf(mapParam.get("password"));
        companyname = StringUtil.valueOf(mapParam.get("companyname"));
        corname = StringUtil.valueOf(mapParam.get("corname"));
        corcardtype = StringUtil.valueOf(mapParam.get("corcardtype"));
        corcardno = StringUtil.valueOf(mapParam.get("corcardno"));
        step = StringUtil.valueOf(mapParam.get("step"));
    }

    /**
     * 入参校验
     * @return
     */
    private Response preCheck(){
        if(ObjectUtils.isEmpty(membertype)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(step)){
            return new Response<>().fail();
        }

        if(ObjectUtils.isEmpty(registersource)){
            return new Response<>().fail();
        }

        if(membertype.equals(company)){
            /**
             * 企业
             */
            if(step.equals(step_1)){
                if(ObjectUtils.isEmpty(membername)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(certificatetype)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(certificateno)){
                    return new Response<>().fail();
                }
            }else if(step.equals(step_2)){

                if(ObjectUtils.isEmpty(corname)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(corcardtype)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(corcardno)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(mobile)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(msgcode)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(cardno)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(bank)){
                    return new Response<>().fail();
                }
            }else if(step.equals(step_3)){
                if(ObjectUtils.isEmpty(password)){
                    return new Response<>().fail();
                }
            }else{
                return new Response<>().fail("0","注册步骤不正确！");
            }
        }else if(membertype.equals(person)){
            /**
             * 个人
             */
            if(step.equals(step_1)){
                if(ObjectUtils.isEmpty(mobile)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(msgcode)){
                    return new Response<>().fail();
                }
            }else if(step.equals(step_2)){
                if(ObjectUtils.isEmpty(membername)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(certificatetype)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(certificateno)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(cardno)){
                    return new Response<>().fail();
                }
                if(ObjectUtils.isEmpty(bank)){
                    return new Response<>().fail();
                }
            }else if(step.equals(step_3)){
                /**
                 * 验证密码
                 */
                if(ObjectUtils.isEmpty(password)){
                    return new Response<>().fail();
                }
            }else{
                return new Response<>().fail("0","注册步骤不正确！");
            }
        }else{
            return new Response<>().fail("0","用户类型不正确！");
        }

        return new Response<>().success();
    }

    /**
     * 用户信息：证件号唯一性检查
     * 忽略大小写
     * @return
     */
    private Response checkCustCertificateno(){
        try {
        CustEntity c = new CustEntity();
        c.setCertificateno(certificateno);
        List<CustEntity> clist = custDao.checkCustCertificatenoIsExist(c);
        if(ObjectUtils.isEmpty(clist)){
            return new Response<>().fail();//证件号码已经使用
        }
    } catch (Exception e) {
            return new Response<>().fail();//检查失败
    }
        return new Response<>().success();
    }

    /**
     * 用户信息：证件号唯一性检查
     * 忽略大小写
     * @return
     */
    private Map getCasRegister(){
        Map<String,Object> entity = new HashMap<>();
        entity.put("membertype",membertype);
        if(membertype.equals(company)){
            entity.put("membername",membername);
            entity.put("certificateno",certificateno);
        }else {
            entity.put("mobile",mobile);
        }
        List<Map> list = casRegisterDao.queryCasRegisterList(entity);
        if(ObjectUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    /**
     * 登录账号唯一性检查
     * @return
     */
    private Response checkCustLoginName(){
        try{
            CustEntity d = new CustEntity();
            d.setLoginname(certificateno);
            List<CustEntity> dlist =  custDao.queryCustEntityList(d);
            if(ObjectUtils.isEmpty(dlist)){
                return new Response<>().fail();//证件号码已经使用
            }
        }catch (Exception e){
            return new Response<>().fail();//检查失败
        }
        return new Response<>().success();
    }

    /**
     * 用户类型+手机号码在cust表校验唯一性
     */
    private Response checkCustMembertypeAndMobile(){
        try{
            CustEntity f = new CustEntity();
            f.setMembertype(membertype);
            f.setMobile(mobile);
            List<CustEntity> flist = custDao.queryCustEntityList(f);
            if(!ObjectUtils.isEmpty(flist)){
                if (person.equals(membertype) && flist.size() >= init_phone_count_person) {
                    return new Response<>().fail();//手机号已使用
                }
                if (company.equals(membertype) && flist.size() >= init_phone_count_organ) {
                    return new Response<>().fail();//手机号已使用
                }
            }
        }catch (Exception e){
            return new Response<>().fail();//检查失败
        }
        return new Response<>().success();
    }

    /**
     *企业名称唯一性检查
     */
    private Response checkOrganName(){
        //企业基本信息表检查
        OrganInfoEntity c = new OrganInfoEntity();
        c.setMembername(membername);
        c.setOrganstatus("");
        List<OrganInfoEntity> clist = organInfoDao.getOrganInfo(c);
        if(!ObjectUtils.isEmpty(clist)){
            return new Response<>().fail();//企业名称已存在
        }
        //企业变更记录表最新插入的一条变更记录 检查
        HashMap<String, Object> amap = new HashMap<String, Object>();
        amap.put("membername", membername);
        List<HashMap<String, Object>> ls;
        try {
            ls = organInfoChangeDao.checkExistCompanynameInChange(amap);
        }catch (Exception e){
            return new Response<>().fail();//查询失败
        }
        if(!ObjectUtils.isEmpty(ls)){
            return new Response<>().fail();//企业名称已存在
        }
        //企业迁入表检查
        OrganRollinEntity cor = new OrganRollinEntity();
        cor.setCompanyname(companyname);
        List<OrganRollinEntity> dlist =  organRollinDao.getOrganRollin(cor);
        if(!ObjectUtils.isEmpty(dlist)){
            return new Response<>().fail();//企业名称已存在
        }
        return new Response<>().success();
    }

    /**
     *写客户信息表
     */
    private Response addCust(Map<String, Object> mapParam){
        try {
            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("status","0");

            custDao.insCust(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response<>().success();
    }

    /**
     * 写个人基本信息表
     */
    private Response addPersonInfo(Map<String, Object> mapParam){
        try {

            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            personInfoDao.insPersonInfo(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response<>().success();
    }

    /**
     * 查询s个人注册基本信息表
     */
    private List<Map> queryCasRegisterInfo(){
             Map<String,Object> entity = new HashMap<>();
            entity.put("membertype",membertype);
            if(membertype.equals(company)){
            entity.put("membername",membername);
            entity.put("certificateno",certificateno);
         }else {
            entity.put("mobile",mobile);
            }
            List<Map> list = casRegisterDao.queryCasRegisterList(entity);
        return list;
    }


    /**
     * 写个人注册基本信息表
     */
    private Response addCasRegisterInfo( String id){
        Map<String,Object> entity = new HashMap<>();
        try {
            entity.put("id",id);
            entity.put("registersource",registersource);
            entity.put("membertype",membertype);
            if(membertype.equals(company)){
                entity.put("membername",membername);
                entity.put("certificatetype",certificatetype);
                entity.put("certificateno",certificateno);
            }else {
                entity.put("mobile",mobile);
            }
            entity.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATETIME));
            casRegisterDao.insCasRegister(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response<>().success();
    }


    /**
     * 修改个人注册基本信息表
     */
    private Response updCasRegisterInfo(Map<String, Object> mapParam){
        try {
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATETIME));
            casRegisterDao.updCasRegister(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response<>().success();
    }

    /**
     * 写企业基本信息表
     */
    private Response addOrganInfo(Map<String, Object> mapParam){
        try {
            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("organstatus","1");
            mapParam.put("version",1);
            organInfoDao.insOrganInfo(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response<>().success();
    }

    /**
     * 写登陆认证表
     */
    private  Response addAuthone(Map<String, Object> mapParam){
        try {
            mapParam.put("customerno",mapParam.get("id"));
            mapParam.put("insertdate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("inserttime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("updatedate",DateUtil.getUserDate(DATE_FMT_DATE));
            mapParam.put("updatetime",DateUtil.getUserDate(DATE_FMT_TIME));
            mapParam.put("password",parseSystemUtil.parseByte2HexStr(aDEncryp.encrypt(password, "MSJFmsjf")));
            mapParam.put("failcount",0);
            mapParam.put("registersource",registersource);
            ausAuthoneDao.inrAusAuthone(mapParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response<>().success();
    }
}
