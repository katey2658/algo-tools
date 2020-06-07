package com.busyzero.algo2;

/**
 * 替换字符串内特殊字符
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/6 10:59 下午
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
