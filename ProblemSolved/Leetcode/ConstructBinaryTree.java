package ProblemSolved.Leetcode;


import datastructures.compiUtils.TreeNode;

class ConstructBinaryTree {
    public static void main(String args[]) {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, preorder);
        printInorder(root);
        System.out.println("root right is " + root.right.val);


    }
    static void printInorder(TreeNode root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + ", ");
        printInorder(root.right);
    }

    static int[] getSlice(int[] arr, int index, int size) {
        int[] result = new int[size];

        if(size == 0)
            return result;

        int count = 0;
        while(size>0) {
            result[count]=arr[index+count];
            count++;
            size--;
        }
        return result;
    }

    static TreeNode buildTree(int[] inorder, int[] preorder) {
        if(preorder.length == 0)
            return null;
        int size = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int leftTreeLength = 0, rightTreeLength = 0;

        if(inorder[0] == preorder[0]){
            rightTreeLength = size-1;
        }
        else if(inorder[size -1] == preorder[0]){
            leftTreeLength = size - 1;
        }
        else {
            int count = 0;
            while(inorder[count] != preorder[0] && count<size) {
                count ++;
            }
            if(inorder[count] != preorder[0]) System.out.println("invalid data");
            leftTreeLength = count;
            rightTreeLength = size - leftTreeLength-1;

        }

        int[] leftIn, rightIn, leftPre, rightPre;

        leftIn = getSlice(inorder, 0, leftTreeLength);
        rightIn = getSlice(inorder, leftTreeLength+1, size-leftTreeLength-1);
        leftPre = getSlice(preorder, 1, leftTreeLength);
        rightPre = getSlice(preorder, leftTreeLength+1, size-leftTreeLength-1);

        root.left = buildTree(leftIn, leftPre);
        root.right = buildTree(rightIn, rightPre);
        return root;
    }
}
