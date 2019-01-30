package com.msjf.finance.cas.facade.organ;

import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;

/**
 * <pre>
 * 描述:
 *    对外开放的接口
 *  <pre/>
 * @author 95494
 * @create 2019-01-22 19:01
 */
public interface OrganServiceFacade {


    /**
     * 添加拟设立-第一步
     *
     * @param mapParam 入参
     * @return com.msjf.finance.msjf.core.response.Response 结果集
     * *************************************************************************************
     * *************************************************************************************
     * @date 2019/01/30 16:56
     * @api {post}/oauth
     * @apiGroup cas接口
     * @apiName setAddApplyFirst
     * @apiVersion 1.0.0
     * @apiPermission none
     * @apiDescription 添加拟设立-第一步
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String="setAddApplyFirst"}  api_name         接口名称[必填]
     * @apiParam {String="setAddApplyFirst"}  method           接口方法[必填]
     * @apiParam {String}                      access_token    授权TOKEN[必填]
     * @apiParam {String}  param       请求入参集合[请根据上面参数进行组装集合]
     * @apiParam {String}              version="1.0.0"         接口版本号[必填]
     * @apiParam {String}                      [sign]          可以为空值[非必填]
     * @apiParam {String}                      [timestamp]     可以为空值[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String{1..32}} orgcustomerno       企业客户代码[必填]
     * @apiParam {String{1..32}} [customerno]        发起人客户代码[必填]
     * @apiParam {String{1..32}} membername          企业名称[必填]
     * @apiParam {String{1..6}="0","1"} organtype    企业类型[必填] 字典104 0-有限公司 1-合伙企业
     * @apiParam {String{1..6}="0","1","2","3","4","5"} organtype[必填]     企业分类 字典105 0-基金管理人企业 1-基金项目产品企业
     * 2-个人自有资金投资平台类企业 3-企业自有资金投资平台类企业 4-融资租赁企业 5-其他企业
     * @apiParam {String{1..32}} registerprovince       注册地址(省)[必填] dict101021
     * @apiParam {String{1..32}} registercity       注册地址(市)[必填] dict101022
     * @apiParam {String{1..32}} registercounty       注册地址(区/县)[必填] dict101023
     * @apiParam {String{1..32}} registertreet       注册地址(街道)[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParamExample {json} Request-Example:
     * {
     * api_name:getOrganInfo
     * method:setAddApplySecond
     * param:[{"customerno":"UR00001","membername":"宁波市瑞芯网络科技合伙企业","organtype":"1"}]
     * access_token:29e7b070-9d1f-4bf7-ad83-2b62038fdf02
     * version:1.0.0
     * sign:
     * timestamp:
     * }
     *
     * @apiSuccess {String} flag      状态码   S：成功， F:没数据/失败
     * @apiSuccess {String} msg       提示信息
     * @apiSuccess {String} flag      状态码
     * @apiSuccess {String} code      服务名称
     * @apiSuccess {Object} data      返回数据
     * @apiSuccessExample {json} Success-Response:
     * {"code":"cas","data":{},"flag":"S","msg":"更新成功"}
     * @apiErrorExample {json} Error-Response:
     * {"code":"cas","data":{},"flag":"S","msg":"更新失败"}
     * @apiSampleRequest /oauth
     *
     */
    Response setAddApplyFirst(HashMap<String, Object> mapParam);

    /**
     * 添加拟设立-第二步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplySecond(HashMap<String, Object> mapParam);

    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplyThirdly(HashMap<String, Object> mapParam);

    /**
     * 添加拟设立-第四步-其它信息
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response setAddApplyFourthly(HashMap<String, Object> mapParam);

    /**
     * 查询企业设立列表信息
     *
     * @param mapParam 入参
     * @return Response 返回结果
     */
    Response getOrganInfoList(HashMap<String, Object> mapParam);

}
