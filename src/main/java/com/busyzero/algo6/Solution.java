package com.busyzero.algo6;

/**
 * 旋转数组的最小数字
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 2:13 下午
 */
public class Solution {
    public int minNumber(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int idx1 = 0, idx2 = array.length - 1;
        while (array[idx1] >= array[idx2]) {
            if (idx2 - idx1 == 1) {
                return array[idx2];
            }
            int mid = (idx1 + idx2) / 2;
            if (array[idx1] == array[idx2] && array[mid] == array[idx1]) {
                for (int i = idx1; i < idx2; i++) {
                    if (array[i] < array[mid]) {
                        return array[i];
                    }
                }
                return array[mid];
            }
            if (array[mid] >= array[idx1]) {
                idx1 = mid;
            } else if (array[mid] <= array[idx2]) {
                idx2 = mid;
            }
        }
        return array[0];
    }
}
