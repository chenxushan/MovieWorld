package com.mobius.leetcode.sys;

import java.util.ArrayList;
import java.util.List;

public class Num155One {
    private List<Integer> stack;
    private Integer size;

    /**
     * initialize your data structure here.
     */
    public Num155One() {
        stack = new ArrayList<>();
        size = 0;
    }

    public void push(int val) {
        stack.add(size++, val);
    }

    public void pop() {
        stack.get(size - 1);
        stack.remove(size - 1);
        size--;
    }

    public int top() {
        return stack.get(size - 1);
    }

    public int getMin() {
        return stack.stream().min(Integer::compareTo).get();
    }
}
