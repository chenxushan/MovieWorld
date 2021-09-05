package com.mobius.thread;

/**
 * 信号量
 *
 * volatile关键字能够保证内存的可见性，如果用volatile关键字声明了一个变量，在一个线程里面改变了这个变量的值，
 * 那其它线程是立马可见更改后的值的。
 *
 * 使用了一个volatile变量signal来实现了“信号量”的模型。这里需要注意的是，volatile变量需要进行原子操作。
 * 需要注意的是，signal++并不是一个原子操作，所以我们在实际开发中，会根据需要使用synchronized给它“上锁”，
 * 或者是使用AtomicInteger等原子类。并且上面的程序也并不是线程安全的，因为执行while语句后，可能当前线程就暂停等待时间片了，
 * 等线程醒来，可能signal已经大于等于5了。
 * 信号量的应用场景：
 * 假如在一个停车场中，车位是我们的公共资源，线程就如同车辆，而看门的管理员就是起的“信号量”的作用。
 * 因为在这种场景下，多个线程（超过2个）需要相互合作，我们用简单的“锁”和“等待通知机制”就不那么方便了。
 * 这个时候就可以用到信号量。其实JDK中提供的很多多线程通信工具类都是基于信号量模型的。
 *
 */
public class Signal {
    private static volatile int signal = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("threadA: " + signal);
                    signal++;
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("threadB: " + signal);
                    signal = signal + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
