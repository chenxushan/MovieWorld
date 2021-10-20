package com.mobius.struct;


import java.util.Deque;
import java.util.LinkedList;

//Java中有一个类Stack，用于表示栈，但这个类已经过时了。Java中没有单独的栈接口，
//        栈相关方法包括在了表示双端队列的接口Deque中，主要有三个方法：
//        push表示入栈，在头部添加元素，栈的空间可能是有限的，如果栈满了，push会抛出异常IllegalStateException。
//        pop表示出栈，返回头部元素，并且从栈中删除，如果栈为空，会抛出异常NoSuchElementException。
//        peek查看栈头部元素，不修改栈，如果栈为空，返回null。
public class StackCase {

    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.push("chenxushan");
        stack.push("is");
        stack.push("man");
        while (stack.peek() != null) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }
    }
}
