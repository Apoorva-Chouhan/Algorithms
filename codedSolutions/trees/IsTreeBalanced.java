package codedSolutions.trees;

import codedSolutions.compiUtils.TreeNode;

public class IsTreeBalanced {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root = root.createTree();
        int height = getTreeHeight(root);
        System.out.println("isbalnced?  "+ isBalanced(root));
    }

    static int getTreeHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Integer.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right))<2);
    }
}
