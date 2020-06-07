package com.busyzero.algo10;

/**
 * 二进制中 1 的个数
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 3:08 下午
 */
public class Solution {
    public int numberOf1(int n) {
       int count = 0;
       while (n != 0) {
           count += n&1;
           n = n >> 1;
       }
       return count;
    }
}
