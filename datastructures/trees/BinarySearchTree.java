package datastructures.trees;

import java.util.*;

public class BinarySearchTree {

    class Node {
        int key;
        Node left, right;

        Node(int val) {
            this.key = val;
            this.left = this.right = null;
        }

        Node(int val, Node left, Node right) {
            this.key = val;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insertKey(int val) {
        this.root = insertNode(root, val);
    }

    Node insertNode(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.key <= val) {
            root.right = insertNode(root.right, val);
        } else {
            root.left = insertNode(root.left, val);
        }
        return root;
    }

    void deleteKey( int val) {
        root = deleteNode(root, val);
    }

    Node deleteNode(Node root, int val) {
        if(root == null) {
            return root;
        }
        if(val< root.key) {
            root.left = deleteNode(root.left, val);
        }
        else if(val>root.key) {
            root.right = deleteNode(root.right, val);
        }
        else {
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minval = root.key;
        while(root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    void inorder() {
        if(this.root == null) return;
        printInorder(this.root);
    }

    void printInorder(Node root) {
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.key);
        printInorder(root.right);

    }

    List<Integer> inorderList(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> roots = new Stack<>();
        Node current = root;
        while(!(current != null || !roots.isEmpty())) {
            while(current != null) {
                roots.push(current);
                current = current.left;
            }
            if(current == null) {
                res.add(roots.peek().key);
                current = roots.pop().right;
            }
        }

        return res;
    }

    List<Integer> levelorder(Node root) {
        Queue<Node> lev = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        lev.add(root);
        while(!lev.isEmpty()) {
            Node current = lev.poll();
            res.add((current != null) ? current.key : null);
//            res.add(current.key);
            if(current != null) {
                lev.add(current.left);
                lev.add(current.right);
            }
        }
        return res;
    }



    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertKey(9);
        bst.insertKey(2);
        bst.insertKey(4);
        bst.insertKey(3);
        bst.insertKey(18);
        bst.insertKey(89);
        bst.insertKey(17);
//        bst.inorder();
//        System.out.println("deleting 9 now");
//        bst.deleteKey(9);
//        bst.inorder();
        List<Integer> inordervals = bst.inorderList(bst.root);
//        for(int i : inordervals) {
//            System.out.println("-> " + i);
//        }
        List<Integer> levOrder = bst.levelorder(bst.root);
        for(int i=0;i<levOrder.size();i++) {
            System.out.println(" --> " + levOrder.get(i));
        }

    }
}
