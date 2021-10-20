package com.mobius.struct;

import java.util.LinkedList;
import java.util.Queue;

//https://blog.csdn.net/yulingmufeng2016/article/details/86287125
//LinkedList实现了Deque和Queue接口，可以按照队列、栈和双端队列的方式进行操作
//一.Queue里面的方法，Queue扩展了Collection，它的主要操作有三个（每个操作2个方法，
//    针对队列长度是否受限制对应是否抛异常---有些队列的是有长度限制的，本例的LinkedList实现queue没长度限制）：
//
//        在尾部添加元素 (add, offer)：
//        add()会在长度不够时抛出异常：IllegalStateException;  offer()则不会,只返回false
//        查看头部元素 (element, peek)，返回头部元素，但不改变队列
//        element()会在没元素时抛出异常：NoSuchElementException;  peek()返回null;
//        删除头部元素 (remove, poll)，返回头部元素，并且从队列中删除
//        remove()会在没元素时抛出异常：NoSuchElementException;  poll()返回null;
public class QueueCase {

    public static void main(String[] args) {
        Queue<String>  queue = new LinkedList<>();

        queue.offer("chen");
        queue.offer("xu");
        queue.offer("shan");
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }

        // 另外一种实现方式
        LinkedList<String> strings = new LinkedList<>();
        // 尾部添加
        strings.addLast("chenxu");
        strings.addLast("shan");
        //获取头部元素
        System.out.println(strings.getFirst());
        //删除头部元素
        System.out.println(strings.removeFirst());
    }


}
