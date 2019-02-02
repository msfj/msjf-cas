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
     * @date 2019/01/30 16:56
     * *************************************************************************************
     * *************************************************************************************
     * @api {post}/oauth
     * @apiGroup cas
     * @apiName setAddApplyFirst
     * @apiVersion 1.0.0
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
     */
    Response setAddApplyFirst(HashMap<String, Object> mapParam);


    /**
     * 添加拟设立-第二步
     *
     * @param mapParam 入参
     * @return com.msjf.finance.msjf.core.response.Response 返回结果
     * @date 2019/01/31 9:42
     * *************************************************************************************
     * *************************************************************************************
     * @api {post} /oauth
     * @apiGroup cas
     * @apiName setAddApplySecond
     * @apiVersion 1.0.0
     * @apiDescription 添加拟设立-第二步
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String="setAddApplySecond"}  api_name         接口名称[必填]
     * @apiParam {String="setAddApplySecond"}  method           接口方法[必填]
     * @apiParam {String}                 access_token     授权TOKEN[必填]
     * @apiParam {String}                 param            请求入参集合[请根据下面参数进行组装集合]
     * @apiParam {String="1.0.0"}         version          接口版本号[必填]
     * @apiParam {String}                 [sign]             可以为空值[非必填]
     * @apiParam {String}                 [timestamp]        可以为空值[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String{1..32}} customerno          发起人客户代码[必填]
     * @apiParam {String{1..32}} orgcustomerno       企业客户代码[必填]
     * @apiParam {String{1..32}} dockingpeople       招商对接人[必填]
     * @apiParam {String{1..32}} dealflow       办理流程[必填] 字典120 0-现场 1-半电子 2-全电子
     * @apiParam {String{1..32}} managelimit       经营期限[必填]
     * @apiParam {String{1..32}} paydatelimit       缴付期限[必填]
     * @apiParam {String{1..32}} regicapitalbz       注册资本金币种[必填] 字典
     * @apiParam {String{1..32}} realprovince       实际地址(省)[必填] 字典[dict101021]
     * @apiParam {String{1..32}} realcity       实际地址(市)[必填] 字典[dict101022]
     * @apiParam {String{1..32}} realcounty       实际地址(区/县)[必填] 字典[ dict101023]
     * @apiParam {String{1..128}} [realtreet]       实际地址(街道)[非必填]
     * @apiParam {String{0..4000}} businessscope       经营范围/主营业务[必填]
     * @apiParam {String{1..32}} organPhone       企业电话[必填]
     * @apiParam {String{1..32}} organEmail       企业邮箱[必填]
     * </per>
     * *************************************************************************************
     * *************************************************************************************
     * @apiParamExample {json} 请求入参实例:
     * {
     * api_name:getOrganInfo
     * method:setAddApplySecond
     * param:[{"customerno":"UR00001","membername":"宁波市瑞芯网络科技合伙企业","organtype":"1"}]
     * access_token:29e7b070-9d1f-4bf7-ad83-2b62038fdf02
     * version:1.0.0
     * sign:
     * timestamp:
     * }
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
     * <p>
     */
    Response setAddApplySecond(HashMap<String, Object> mapParam);


    /**
     * 添加拟设立-第三步
     *
     * @param mapParam 入参
     * @return com.msjf.finance.msjf.core.response.Response 返回结果
     * *************************************************************************************
     * *************************************************************************************
     * @date 2019/01/31 10:11
     * @api {post} /oauth
     * @apiGroup cas
     * @apiName setAddApplyThirdly
     * @apiVersion 1.0.0
     * @apiDescription 添加拟设立-第三步
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String="setAddApplyThirdly"}  api_name         接口名称[必填]
     * @apiParam {String="setAddApplyThirdly"}  method           接口方法[必填]
     * @apiParam {String}                 access_token     授权TOKEN[必填]
     * @apiParam {String}                 param            请求入参集合[请根据下面参数进行组装集合]
     * @apiParam {String="1.0.0"}         version          接口版本号[必填]
     * @apiParam {String}                 [sign]             可以为空值[非必填]
     * @apiParam {String}                 [timestamp]        可以为空值[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String{1..32}} customerno          发起人客户代码[必填]
     * @apiParam {String{1..32}} orgcustomerno       企业客户代码[必填]
     * @apiParam {String{1..32}="0","1"} partnertype         执行事务合伙人类型[必填] 字典 107 0-个人 1-公司 -合伙企业属性
     * @apiParam {String{1..32}} partnername       执行事务合伙人名称[必填]
     * @apiParam {String} memberinfo       投资人/合伙人信息 listStr[必填]
     * <p>
     * memberinfo=[{"username":"成员信息[姓名]","certificatetype":"成员信息[证件类型]","certificateno":"成员信息[证件号]",
     * "mobile":"成员信息[手机号码]",
     * "position":"成员信息[身份类型] 字典 117","dutyway":"成员信息[承担责任方式]","dutyway":"成员信息[出资方式]","amount":"成员信息[认缴出资额]","":"",
     * "paydatelimit":"成员信息[缴付期限]","address":"成员信息[住所]"}]
     * <p>
     * @apiParamExample {json} 请求入参实例:
     * {
     * api_name:getOrganInfo
     * method:setAddApplyThirdly
     * param:[{"customerno":"UR00001","membername":"宁波市瑞芯网络科技合伙企业","organtype":"1"}]
     * access_token:29e7b070-9d1f-4bf7-ad83-2b62038fdf02
     * version:1.0.0
     * sign:
     * timestamp:
     * }
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
     * </per>
     */
    Response setAddApplyThirdly(HashMap<String, Object> mapParam);


    /**
     * 添加拟设立-第四步-其它信息
     *
     * @param mapParam 入参
     * @return com.msjf.finance.msjf.core.response.Response 返回结果
     * *************************************************************************************
     * *************************************************************************************
     * @date 2019/1/31 22:41
     * @api {post} /oauth
     * @apiGroup cas
     * @apiName setAddApplyFourthly
     * @apiVersion 1.0.0
     * @apiDescription 添添加拟设立-第四步-其它信息
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String}  api_name="setAddApplyFourthly"         接口名称[必填]
     * @apiParam {String}  method="setAddApplyFourthly"           接口方法[必填]
     * @apiParam {String}                 access_token     授权TOKEN[必填]
     * @apiParam {Object}                 param            请求入参集合[请根据下面参数进行组装集合]
     * @apiParam {String}         version="1.0.0"          接口版本号[必填]
     * @apiParam {String}                 sign             可以为空值[非必填]
     * @apiParam {String}                 timestamp        可以为空值[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String{1..32}} customerno          发起人客户代码[必填]
     * @apiParam {String{1..32}} orgcustomerno       企业客户代码[必填]
     * @apiParam {String{1..32}} [mainworkexp]         主要负责人从业经历介绍
     * @apiParam {String{1..32}} othersintro       其他主要负责人介绍
     * @apiParam {String{1..32}} partnerintro       股东背景介绍
     * @apiParam {String{1..32}} mployedPeopleNumbere       从业人数数量
     * @apiParam {String{1..32}} industryMarketType       企投资所关注行业市场类型（企业自有资金-所投项目所属行业 dict20025）
     * @apiParam {String{1..32}} focusProjectPhase       关注的项目阶段
     * @apiParam {String{1..32}} returnInvestment       投资获得收益方式（其他企业-盈利模式）
     * @apiParam {String{1..32}} adjunct       附件(多个附件相对地址用逗号分割)
     * @apiParam {String{1..32}} remarks       备注
     * <p>
     * *************************************************************************************
     * *************************************************************************************
     * @apiParamExample {json} 请求入参实例:
     * {
     * api_name:getOrganInfo
     * method:setAddApplyFourthly
     * param:[{"customerno":"UR00001","membername":"宁波市瑞芯网络科技合伙企业","organtype":"1"}]
     * access_token:29e7b070-9d1f-4bf7-ad83-2b62038fdf02
     * version:1.0.0
     * sign:
     * timestamp:
     * }
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
     * <p>
     */
    Response setAddApplyFourthly(HashMap<String, Object> mapParam);

    /**
     * 查询企业设立列表信息
     * @date 2019/1/31 22:53
     * @param mapParam 入参
     * @return com.msjf.finance.msjf.core.response.Response 返回结果
     * *************************************************************************************
     * *************************************************************************************
     * @api {post} /oauth
     * @apiGroup cas
     * @apiName getOrganInfoList
     * @apiVersion 1.0.0
     * @apiPermission none
     * @apiDescription 查询企业设立列表信息
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String}  api_name="getOrganInfoList"         接口名称[必填]
     * @apiParam {String}  method="getOrganInfoList"           接口方法[必填]
     * @apiParam {String}                 access_token     授权TOKEN[必填]
     * @apiParam {Object}                 param            请求入参集合[请根据下面参数进行组装集合]
     * @apiParam {String}         version="1.0.0"          接口版本号[必填]
     * @apiParam {String}                 [sign]             可以为空值[非必填]
     * @apiParam {String}                 [timestamp]        可以为空值[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParam {String{1..32}} orgcustomerno       企业客户代码[必填]
     * @apiParam {String{1..32}} customerno          发起人客户代码[必填]
     * @apiParam {String{1..32}} [membername]       企查询条件：企业公司名称[非必填]
     * *************************************************************************************
     * *************************************************************************************
     * @apiParamExample {json} 请求入参实例:
     * {
     * api_name:getOrganInfo
     * method:getOrganInfoList
     * param:[{"customerno":"UR00001","membername":"宁波市瑞芯网络科技合伙企业","organtype":"1"}]
     * access_token:29e7b070-9d1f-4bf7-ad83-2b62038fdf02
     * version:1.0.0
     * sign:
     * timestamp:
     * }
     *
     *
     * @apiSuccess {String} flag      状态码   S：成功， F:没数据/失败
     * @apiSuccess {String} msg       提示信息
     * @apiSuccess {String} flag      状态码
     * @apiSuccess {String} code      服务名称
     * @apiSuccess {Object} data      返回数据
     *
     *
     * @apiSuccessExample {json} Success-Response:
     * {"code":"cas","data":{},"flag":"S","msg":"更新成功"}
     *
     *
     * @apiErrorExample {json} Error-Response:
     * {"code":"cas","data":{},"flag":"S","msg":"更新失败"}
     *
     *
     * @apiSampleRequest /oauth
     * <p>
     */
    Response getOrganInfoList(HashMap<String, Object> mapParam);


    /**
     * 删除未提交确认设立的企业设立信息
     * @param mapParam 入参
     * @return 返回结果
     */
    Response setDeleteOrgan(HashMap<String, Object> mapParam);

}
