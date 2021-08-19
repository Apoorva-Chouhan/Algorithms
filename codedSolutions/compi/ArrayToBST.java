package codedSolutions.compi;

import codedSolutions.compiUtils.TreeNode;

import java.util.Arrays;

public class ArrayToBST {
    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        int[] ar = {-10,-3,0,5,9};
        root = sortedArrayToBST(ar);
        TreeNode.printInorder(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);
        TreeNode root = new TreeNode(nums[nums.length/2]);
        int[] left = Arrays.copyOfRange(nums, 0 , nums.length/2);
        int[] right = Arrays.copyOfRange(nums, nums.length/2+1, nums.length);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }

}
