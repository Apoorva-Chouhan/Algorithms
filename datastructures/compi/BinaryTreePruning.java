package datastructures.compi;

import datastructures.compiUtils.TreeNode;

public class BinaryTreePruning {
    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = root.createTree();
        System.out.println("before prune inorder");
        TreeNode.printInorder(root);
        prunerFunc(root);
        System.out.println("after prune inorder");
        TreeNode.printInorder(root);
    }

    public static TreeNode prunerFunc(TreeNode<Integer> root) {

        if (root.left != null) root.left = prunerFunc(root.left);
        if (root.right != null) root.right = prunerFunc(root.right);
        if (root.left == null && root.right == null) {
            if (root.val != 1) root = null;
        }
        return root;
    }
}
