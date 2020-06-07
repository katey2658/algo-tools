package com.busyzero.algo7;

/**
 * fibonacci数列
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 2:42 下午
 */
public class Solution {
    public int fibonacci(int n) {
        if(n < 1) return 0;
        int [] fibonacci = new int[2];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        n = 2;
        while (n > 0) {
            int temp = fibonacci[0] +fibonacci[1];
            fibonacci[0] = fibonacci[1];
            fibonacci[1] = temp;
            n --;
        }
        return fibonacci[1];
    }
}
