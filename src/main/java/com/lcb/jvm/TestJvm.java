package com.lcb.jvm;

import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 类Test.java的实现描述：TODO 类实现描述 
 *
 * @author zhaoxiaoliang 2019年12月17日 上午9:43:59
 */
public class TestJvm {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> inputArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("\n#####################运行时设置的JVM参数#######################");
        System.out.println(inputArgs);
        
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("sun.boot.library.path"));
    }

}
