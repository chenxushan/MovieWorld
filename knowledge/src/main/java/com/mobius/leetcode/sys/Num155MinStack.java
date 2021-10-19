package com.mobius.leetcode.sys;

import java.util.*;

public class Num155MinStack {

    private List<Integer> dataList;
    private Stack<Integer> minStack;
    private Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //升序
            return o1-o2;
            //降序
            //return o2-o1;
        }
    };
    public Num155MinStack() {
        minStack = new Stack<>();
        dataList = new ArrayList<>();
    }

    public void push(int val) {
        minStack.push(val);
        dataList.add(val);
        Collections.sort(dataList);
    }

    public void pop() {

        if (!minStack.isEmpty()) {
            int removeValue = minStack.pop();
            int indexRemove = dataList.indexOf(removeValue);
            if (indexRemove>=0) {
                dataList.remove(indexRemove);
            }

        }
        Collections.sort(dataList);

    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        int min = dataList.get(0);
        return min;
    }

    public static void main(String[] args) {
        Num155MinStack minStack = new Num155MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();


    }
}
