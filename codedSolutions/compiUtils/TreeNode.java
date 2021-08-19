package codedSolutions.compiUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode<T> {

    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode createTree() {
        TreeNode root = new TreeNode();
        Queue<TreeNode> nodelist = new LinkedList<>();
        System.out.println("Enter value for root");
        Scanner s = new Scanner(System.in);
        root.val = s.nextInt();
        nodelist.add(root);
        System.out.println("Enter values for all children, enter 0 where you don't want to add a value");
        while (!nodelist.isEmpty()) {
            int val;
            TreeNode node = nodelist.poll();
            System.out.println("Enter value for left child of " + node.val);
            val = s.nextInt();
            if (val != 0) {
                node.left = new TreeNode(val);
                nodelist.add(node.left);
            }
            System.out.println("Enter value for right child of " + node.val);
            val = s.nextInt();
            if (val != 0) {
                node.right = new TreeNode(val);
                nodelist.add(node.right);
            }
        }
        return root;
    }

    public static void printInorder(TreeNode root) {
        if(root.left != null) printInorder(root.left);
        System.out.println("->" + root.val);
        if(root.right != null) printInorder(root.right);
    }


    // check how to use the above methods below

//    public static void main(String args[]) {
//        TreeNode node = createTree();
//        TreeTraversals obj = new TreeTraversals();
//        List<Integer> inorderList = obj.getInorder(node);
//        System.out.println("inorder traversal of entered tree");
//        for(int i: inorderList) {
//            System.out.print(i + " -> ");
//        }
//    }

}
