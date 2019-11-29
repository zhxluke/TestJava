package com.lcb.template;
/**
 * 类Response.java的实现描述：TODO 类实现描述 
 *
 * @author zhaoxiaoliang 2019年11月29日 上午11:34:22
 */
public class Response<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    
}
