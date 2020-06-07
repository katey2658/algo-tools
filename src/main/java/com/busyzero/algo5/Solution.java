package com.busyzero.algo5;

import java.util.Stack;

/**
 * 两个栈实现队列
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 1:51 下午
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws  Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
