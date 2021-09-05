package com.mobius.thread;

public class MyThread {
    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread1();
        myThread.start();
    }
}
