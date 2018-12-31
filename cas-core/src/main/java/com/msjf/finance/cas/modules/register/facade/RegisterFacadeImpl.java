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
import com.msjf.finance.cas.modules.register.dao.CustDao;
import com.msjf.finance.cas.modules.register.dao.RegisterDao;
import com.msjf.finance.cas.modules.register.entity.CustEntity;
import com.msjf.finance.cas.modules.register.service.RegisterService;
import com.msjf.finance.cas.modules.util.*;
import org.springframework.stereotype.Service;
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
public class RegisterFacadeImpl extends Account implements RegisterFacade{
    @Resource
    RegisterService registerService;

    @Resource
    RegisterDao registerDao;

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

    /**
     * 用户类型
     */
    private String membertype;

    /**
     * 注册来源 0-web 1-app
     */
    private String registersource;

    /**
     * 来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
     */
    private String source;

    /**
     * 用户名称
     */
    private String membername;

    /**
     * 证件类型 0-身份证 1-护照 D-营业执照
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
     * 邀请码
     */
    private String invitecode;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 就职单位
     */
    private String companyname;

    /**
     * 企业类型
     */
    private String organtype;

    /**
     * 企业分类
     */
    private String organclass;

    /**
     * 联系人姓名
     */
    private String linkmanname;

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
            checkCustCertificateno(); //证件号在cust表校验唯一性
            checkCustLoginName();//登陆账号唯一
            checkCustMembertypeAndMobile();//用户类型+手机号码在cust表校验唯一性
            //短信验证码检查
            //企业名称唯一检查
            if (membertype.equals(YES)) {
                checkOrganName();
            }
           customerno =  CommonUtil.generatorCustid();//生成customerno/appSerialno
            appSerialno = DateUtil.getUserDate(DATE_FMT_DATE + DATE_FMT_TIME) + CommonUtil.getRandomCode(1, 6);
            addCust();//写用户基本信息表
            if (membertype.equals(NO)) {//个人
                addPersonInfo();
            } else {//企业
                addOrganInfo();
            }
            addAuthone();
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
        source = StringUtil.valueOf(mapParam.get("source"));
        membername = StringUtil.valueOf(mapParam.get("membername"));
        certificatetype = StringUtil.valueOf(mapParam.get("certificatetype"));
        certificateno = StringUtil.valueOf(mapParam.get("certificateno"));
        mobile = StringUtil.valueOf(mapParam.get("mobile"));
        cardno = StringUtil.valueOf(mapParam.get("cardno"));
        bank = StringUtil.valueOf(mapParam.get("bank"));
        msgcode = StringUtil.valueOf(mapParam.get("msgcode"));
        password = StringUtil.valueOf(mapParam.get("password"));
        invitecode = StringUtil.valueOf(mapParam.get("invitecode"));
        email = StringUtil.valueOf(mapParam.get("email"));
        companyname = StringUtil.valueOf(mapParam.get("companyname"));
        organtype = StringUtil.valueOf(mapParam.get("organtype"));
        organclass = StringUtil.valueOf(mapParam.get("organclass"));
        linkmanname = StringUtil.valueOf(mapParam.get("linkmanname"));
    }

    /**
     * 入参校验
     * @return
     */
    private Response preCheck(){
        if(ObjectUtils.isEmpty(membertype)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(registersource)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(source)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(membername)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(certificatetype)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(certificateno)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(mobile)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(cardno)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(bank)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(msgcode)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(password)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(invitecode)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(email)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(companyname)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(organtype)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(organclass)){
            return new Response<>().fail();
        }
        if(ObjectUtils.isEmpty(linkmanname)){
            return new Response<>().fail();
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
                if ("0".equals(membertype) && flist.size() >= init_phone_count_person) {
                    return new Response<>().fail();//手机号已使用
                }
                if ("1".equals(membertype) && flist.size() >= init_phone_count_organ) {
                    return new Response<>().fail();//手机号已使用
                }
                return new Response<>().fail();//证件号码已经使用
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
        List<OrganInfoEntity> clist = organInfoDao.getOrganInfo(c);
        if(ObjectUtils.isEmpty(clist)){
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
        if(ObjectUtils.isEmpty(ls)){
            return new Response<>().fail();//企业名称已存在
        }
        //企业迁入表检查
        OrganRollinEntity cor = new OrganRollinEntity();
        cor.setCompanyname(companyname);
        List<OrganRollinEntity> dlist =  organRollinDao.getOrganRollin(cor);
        if(ObjectUtils.isEmpty(dlist)){
            return new Response<>().fail();//企业名称已存在
        }
        return new Response<>().success();
    }

    /**
     *写客户信息表
     */
    private Response addCust(){
        try {
            CustEntity cifCustEntity = new CustEntity();
            cifCustEntity.setCustomerno(customerno);
            cifCustEntity.setLoginname(certificateno);
            cifCustEntity.setMembertype(membertype);
            cifCustEntity.setCertificatetype(certificatetype);
            cifCustEntity.setCertificateno(certificateno);
            cifCustEntity.setLinkmanname(linkmanname);
            cifCustEntity.setMobile(mobile);
            cifCustEntity.setCardno(cardno);
            cifCustEntity.setBank(bank);
            cifCustEntity.setCompanyname(companyname);
            cifCustEntity.setEmail(email);
            cifCustEntity.setStatus("0");
            cifCustEntity.setInsertdate(DateUtil.getUserDate(DATE_FMT_DATE));
            cifCustEntity.setInserttime(DateUtil.getUserDate(DATE_FMT_TIME));
            cifCustEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
            cifCustEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
            cifCustEntity.setSource(source);
            custDao.insCust(cifCustEntity);
        } catch (Exception e) {
            return new Response<>().fail();//cif_cust表写失败
        }
        return new Response<>().success();
    }

    /**
     * 写个人基本信息表
     */
    private Response addPersonInfo(){
        try {
            PersonInfoEntity cifPersonInfoEntity = new PersonInfoEntity();
            cifPersonInfoEntity.setCustomerno(customerno);
            cifPersonInfoEntity.setMembername(membername);
            cifPersonInfoEntity.setInsertdate(DateUtil.getUserDate(DATE_FMT_DATE));
            cifPersonInfoEntity.setInserttime(DateUtil.getUserDate(DATE_FMT_TIME));
            cifPersonInfoEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
            cifPersonInfoEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
            personInfoDao.insPersonInfo(cifPersonInfoEntity);
        } catch (Exception e) {
            return new Response<>().fail();//cif_cust表写失败
        }
        return new Response<>().success();
    }

    /**
     * 写企业基本信息表
     */
    private Response addOrganInfo(){
        try {
            OrganInfoEntity cifOrganInfoEntity = new OrganInfoEntity();
            cifOrganInfoEntity.setCustomerno(customerno);
            cifOrganInfoEntity.setVersion(1);
            cifOrganInfoEntity.setMembername(membername);
            cifOrganInfoEntity.setOrgantype(organtype);
            cifOrganInfoEntity.setOrganclass(organclass);
            cifOrganInfoEntity.setOrganstatus("1");
            cifOrganInfoEntity.setInsertdate(DateUtil.getUserDate(DATE_FMT_DATE));
            cifOrganInfoEntity.setInserttime(DateUtil.getUserDate(DATE_FMT_TIME));
            cifOrganInfoEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
            cifOrganInfoEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
            cifOrganInfoEntity.setSource(source);//来源：0-个人服务平台注册；1-企业注册服务平台；2-企业三方会签
            organInfoDao.insOrganInfo(cifOrganInfoEntity);
        } catch (Exception e) {
            return new Response<>().fail();//cif_organ_info表写失败");
        }
        return new Response<>().success();
    }

    /**
     * 写登陆认证表
     */
    private  Response addAuthone(){
        try {
            AusAuthoneEntity ausAuthoneEntity = new AusAuthoneEntity();
            ausAuthoneEntity.setCustomerno(customerno);
            ausAuthoneEntity.setPassword(parseSystemUtil.parseByte2HexStr(aDEncryp.encrypt(password, "MSJFmsjf")));
            ausAuthoneEntity.setFailcount(0);
            ausAuthoneEntity.setOnlinestatus("N");//N-不在线 Y-在线
            ausAuthoneEntity.setRegistersource(registersource);//0-web 1-app
            ausAuthoneEntity.setInsertdate(DateUtil.getUserDate(DATE_FMT_DATE));
            ausAuthoneEntity.setInserttime(DateUtil.getUserDate(DATE_FMT_TIME));
            ausAuthoneEntity.setUpdatedate(DateUtil.getUserDate(DATE_FMT_DATE));
            ausAuthoneEntity.setUpdatetime(DateUtil.getUserDate(DATE_FMT_TIME));
            ausAuthoneDao.inrAusAuthone(ausAuthoneEntity);
        } catch (Exception e) {
            return new Response<>().fail();
        }
        return new Response<>().success();
    }
}
