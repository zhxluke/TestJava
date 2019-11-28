package com.lcb.schedule;

import java.util.concurrent.Semaphore;

/**
 * 类PrintABCUsingSemaphore.java的实现描述：TODO 类实现描述
 *
 * @author zhaoxiaoliang 2019年11月26日 下午5:36:26
 */
public class PrintABCUsingAtomic {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
    }

}

class PrintAutomtic implements Runnable {
    private String    name;
    private Semaphore current;
    private Semaphore next;

    public PrintAutomtic(String name, Semaphore current, Semaphore next) {
        this.name = name;
        this.current = current;
        this.next = next;
    }

    @Override
    public void run() {
        print(name, current, next);
    }

    /**
     * @param name
     * @param current
     * @param next
     */
    private void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < 10; i++) {
            try {
                current.acquire();
                System.out.println(Thread.currentThread().getName() + "->" + name);
                next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
