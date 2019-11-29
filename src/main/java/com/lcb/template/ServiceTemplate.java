package com.lcb.template;

/**
 * 类ServiceTemplate.java的实现描述：TODO 类实现描述
 *
 * @author zhaoxiaoliang 2019年11月29日 上午11:05:31
 */
public abstract class ServiceTemplate<REQUEST extends BaseDTO, RESPONSE extends Response<?>, RESULT> {

    /**
     * @param request
     * @return
     */
    public RESPONSE execute(REQUEST request) {
        // 参数校验
        validate(request);

        // 业务处理
        RESULT result = doService(request);

        // 结果返回
        return doResult(result);
    }

    /**
     * @param request
     */
    protected abstract void validate(REQUEST request);

    /**
     * @param request
     * @return
     */
    protected abstract RESULT doService(REQUEST request);

    /**
     * @param result
     * @return
     */
    protected abstract RESPONSE doResult(RESULT result);
}
