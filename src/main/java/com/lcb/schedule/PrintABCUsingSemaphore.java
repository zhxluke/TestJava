package com.lcb.schedule;

import java.util.concurrent.Semaphore;

/**
 * 类PrintABCUsingSemaphore.java的实现描述：TODO 类实现描述
 *
 * @author zhaoxiaoliang 2019年11月26日 下午5:36:26
 */
public class PrintABCUsingSemaphore {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new PrintSemaphore("A", semaphoreA, semaphoreB)).start();
        new Thread(new PrintSemaphore("C", semaphoreC, semaphoreA)).start();
        new Thread(new PrintSemaphore("B", semaphoreB, semaphoreC)).start();
    }

}

class PrintSemaphore implements Runnable {
    private String    name;
    private Semaphore current;
    private Semaphore next;

    public PrintSemaphore(String name, Semaphore current, Semaphore next) {
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
