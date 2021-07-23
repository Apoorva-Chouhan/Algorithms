package datastructures.trees;

import datastructures.compiUtils.TreeNode;

public class MaxDepth {

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = root.createTree();
        int depth = maxDepth(null);
        System.out.println("max depth " + depth);
    }

    public static int maxDepth(TreeNode root) {
        int result = 0;
        int left =0, right=0;
        if(root.left != null) {
            left = 1 + maxDepth(root.left);
        }
        if(root.right != null) {
            right = 1 + maxDepth(root.right);
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        result = Integer.max(left, right);
        return result;
    }

}
