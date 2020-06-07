package com.busyzero.algo1;

/**
 * @Description 一个二维数组中查找，从左到右递增，从上到下递增， 找到一个数
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/6 10:39 下午
 */
public class Solution {
    public boolean find(int target, int[][] array) {
        if (array == null && array.length == 0)  {
            return false;
        }
        int rowIdx = 0, colIdx = array[0].length - 1;
        while (rowIdx < array.length  && colIdx >= 0) {
            if (array[rowIdx][colIdx] == target) {
                return true;
            } else if (array[rowIdx][colIdx] < target) {
                rowIdx--;
            } else if (array[rowIdx][colIdx] > target) {
                colIdx--;
            }
        }
        return false;
    }
}
