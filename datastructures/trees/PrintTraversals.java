package datastructures.trees;

import java.util.*;

public class PrintTraversals {
    public static void main(String args[]) {
        Basictree tree = Basictree.getTree();
        PrintTraversals.printInorder(tree.root);
////        PrintTraversals.printPreorder(tree.root);
//        PrintTraversals.printPostorder(tree.root);
////        PrintTraversals.nonRecursiveInorder(tree.root);
//        PrintTraversals.nonRecursivePostorder(tree.root);
        PrintTraversals.morrisInorderTraversal(tree.root);
    }
    public static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.key + ", ");
        printInorder(root.right);
    }
    public static void printPreorder(Node root) {
        if(root == null) return;
        System.out.print(root.key + ", ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void printPostorder(Node root) {
        if(root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.key + ", ");
    }
    public static void nonRecursiveInorder(Node root) {
        Stack<Node> s = new Stack<>();
        if(root == null) {
            System.out.println("empty tree");
            return;
        }

        Node current = root.left;
        s.push(root);
        while(current != null || !s.isEmpty()) {
            while (current != null) {
                // for non recursive preorder, print current.key here
                s.push(current);
                current = current.left;
            }
            if(current == null) {
                if(!s.isEmpty()) {
                    Node res = s.pop();
                    System.out.print(res.key + " ");
                    current = res.right;
                }
            }
        }
    }

    public static void nonRecursivePostorder(Node root) {
        if(root == null){
            System.out.println("empty tree");
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        Stack<Node> roots = new Stack<>();
//        roots.push(root);
        Node current = root.left;   //current should be root. if root has only right subtree, this would fail.
        while(current != null || !s.isEmpty()) {
            while(current != null){
                s.push(current);
                current=current.left;
            }
            if(current == null){
                if (!roots.isEmpty() && s.peek() != roots.peek()) {
                    System.out.print(s.peek().key + " ");
                    s.pop();
                } else if (!roots.isEmpty() && s.peek() == roots.peek()) {  //both left and right subtree of node are processed, process and pop the root
                    System.out.print(s.peek().key + " ");
                    s.pop();
                    roots.pop();
                }
                else {  //left subtree is processed but right subtree is still to be processed
                    roots.push(s.peek());
                    current = s.peek().right;
                }
            }
        }
    }

    public static void morrisInorderTraversal(Node root) {
        Node current = root;
        while(current != null) {
            if(current.left == null) {
                System.out.print(current.key + " ");
                current = current.right;
            }
            else {
                Node predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else
                {
                    predecessor.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
                }
            }

        }
    }

}
