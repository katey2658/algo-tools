package com.busyzero.algo4;

/**
 * 使用前序遍历和后续遍历重新构建二叉树
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/6 11:15 下午
 */
public class Solution {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return doReConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode doReConstructBinaryTree(int[] pre, int preStartIdx, int preEndIdx, int[] in, int inStartIdx, int inEndIdx) {
        TreeNode node = new TreeNode(pre[preEndIdx]);
        if (preStartIdx == preEndIdx) {
            if (inStartIdx != inEndIdx || pre[preStartIdx] != in[inStartIdx]) {
                System.out.println("Invalid  input");
            }
        }
        int i = 0;
        while (pre[preStartIdx] != in[inStartIdx + i]) {
            i++;
        }
        if (i == 0) { // 证明没有左子树
            node.left = null;
        } else {
            node.left = doReConstructBinaryTree(pre, preStartIdx + 1, preStartIdx + i, in, inStartIdx, inStartIdx + i -1);
        }
        if (inStartIdx + i == inEndIdx) {
            node.right = null; // 证明没有右子树
        } else {
            node.right = doReConstructBinaryTree(pre, preStartIdx + i + 1, preEndIdx, in,  inStartIdx + i + 1, inEndIdx);
        }
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val)  {
            this.val = val;
        }
    }
}
