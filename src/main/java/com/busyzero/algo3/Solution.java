package com.busyzero.algo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 打印一个链表，从尾打到头
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/6 11:04 下午
 */
public class Solution {
    public List<Integer> printListFromTailToHead(Node node) {
        List<Integer> resultList = new ArrayList<>();
        if (node == null) {
            return resultList;
        }
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }

    public static class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }
}
