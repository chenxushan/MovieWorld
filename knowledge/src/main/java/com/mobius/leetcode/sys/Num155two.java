package com.mobius.leetcode.sys;

import java.util.LinkedList;

/**
 * 双端队列，最小值放前面，当前值放后面。
 */
public class Num155two {
    int min = Integer.MAX_VALUE;
    LinkedList<Integer> list;
    /** initialize your data structure here. */
    public Num155two() {
        min = Integer.MAX_VALUE;
        list = new LinkedList<Integer>();
    }

    public void push(int val) {
        list.add(val);
        list.addFirst(val <= min ? val : min);
        min = list.peek();
    }

    public void pop() {
        list.pollLast();
        list.poll();
        min = list.isEmpty() ? Integer.MAX_VALUE : list.peek();
    }

    public int top() {
        return list.peekLast();
    }

    public int getMin() {
        return min;
    }

}
