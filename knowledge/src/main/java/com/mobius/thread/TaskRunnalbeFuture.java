package com.mobius.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

// 自定义Callable，与上面一样
class TaskRunnalbeFuture implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算需要一秒
        Thread.sleep(1000);
        return 2;
    }
    public static void main(String args[]) throws Exception {
        // 使用
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new TaskRunnalbeFuture());
        // 没有返回值
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
