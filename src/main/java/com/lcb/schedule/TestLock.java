package com.lcb.schedule;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类TestLock.java的实现描述：TODO 类实现描述
 *
 * @author zhaoxiaoliang 2019年12月19日 下午5:45:12
 */
public class TestLock {
    private static int       count      = 0;

    private static final int COUNT_BITS = Integer.SIZE - 3;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   = 0 << COUNT_BITS;
    private static final int STOP       = 1 << COUNT_BITS;
    private static final int TIDYING    = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        SimpleSpinningLock simpleSpinningLock = new TestLock().new SimpleSpinningLock();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    simpleSpinningLock.lock();
                    ++count;
                    System.out.println("count->" + count);
                    countDownLatch.countDown();
                    System.out.println("getCount->" + countDownLatch.getCount());
                    simpleSpinningLock.unLock();
                }
            });

        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(count);

        System.out.println("SHUTDOWN->" + RUNNING);
        System.out.println("SHUTDOWN->" + SHUTDOWN);
        System.out.println("STOP->" + STOP);
        System.out.println("TIDYING->" + TIDYING);
        System.out.println("TERMINATED->" + TERMINATED);
    }

    class SimpleSpinningLock {

        /**
         * 持有锁的线程，null表示锁未被线程持有
         */
        private AtomicReference<Thread> ref = new AtomicReference<>();

        public void lock() {
            Thread currentThread = Thread.currentThread();
            while (!ref.compareAndSet(null, currentThread)) {
                //
            }
            System.out.println(currentThread.getName() + "->lock");
        }

        public void unLock() {
            Thread currentThread = Thread.currentThread();
            if (ref.get() != currentThread) {
                //
            }
            System.out.println(currentThread.getName() + "->unLock");
            ref.set(null);
        }
    }
}
