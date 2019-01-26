package com.msjf.finance.cas.modules;

import com.msjf.finance.msjf.core.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 描述:
 *    ${DESCRIPTION}
 *  <pre/>
 * @author 95494
 * @create 2019-01-26 11:00
 */
public interface IApp {

    Logger logger = LogManager.getLogger(IApp.class);


    /**
     * 入参检查
     * @param mapParam 入参
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    boolean preCheck(HashMap<String, Object> mapParam, Response rs);

    /**
     * 缓存数据
     * @param mapParam 入参
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    boolean cache(HashMap<String, Object> mapParam, Response rs);

    /**
     * 业务参数检查
     * @param mapParam 入参
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    boolean check(HashMap<String, Object> mapParam, Response rs);

    /**
     * 业务处理前操作
     * @param mapParam 入参
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    boolean before(HashMap<String, Object> mapParam, Response rs);

    /**
     * 业务处理
     * @param mapParam 入参
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    boolean clear(HashMap<String, Object> mapParam, Response rs);

    /**
     * 业务处理后操作
     * @param mapParam 入参
     * @param rs 结果集
     * @return false 失败 true 成功
     */
    boolean after(HashMap<String, Object> mapParam, Response rs);

    /**
     * 业务执行方法
     *
     * @param mapParam 入参
     * @param rs       结果集
     */
    default void doSingleService(HashMap<String, Object> mapParam, Response rs) {
        try {

            if ((!preCheck(mapParam, rs)) || (!cache(mapParam, rs)) || (!check(mapParam, rs)) || (!before(mapParam,
                    rs))) {
                return;
            }

            if (!clear(mapParam, rs)) {
                throw new RuntimeException(rs.getMsg());
            }
            if (!after(mapParam, rs)) {
                throw new RuntimeException(rs.getMsg());
            }

        } catch (Exception e) {
            logger.error("业务处理失败:" + e.getMessage(), e);
            Map<String, Object> rsMap = new HashMap<>(2);
            rsMap.put("exceptionMessage", e.getMessage());
            rsMap.put("rsErrMessage", rs.getMsg());
            rs.success("cas", "业务处理失败:", rsMap);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
