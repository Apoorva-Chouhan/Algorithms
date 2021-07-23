package ProblemSolved.Leetcode;

import datastructures.compiUtils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return true;
        }
    }

    void levelTraverse(TreeNode p, TreeNode q) {
        Queue<TreeNode> treep, treeq;
        treep = new LinkedList<>();
        treeq = new LinkedList<>();
        treep.add(null);

    }

    void levelorder(TreeNode root) {
        Queue<TreeNode> lev = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        lev.add(root);
        while(!lev.isEmpty()) {
            TreeNode current = lev.poll();
            res.add((current != null) ? (Integer)current.val : null);
            if(current != null) {
                lev.add(current.left);
                lev.add(current.right);
            }
        }
    }


    public static void main(String args[]) {

    }
}
