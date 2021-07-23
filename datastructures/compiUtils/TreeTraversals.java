package datastructures.compiUtils;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversals <T> {

    public List<Object> getInorder(TreeNode root) {
        List<Object> inorderTraversal = new ArrayList<>();
        inorder(inorderTraversal, root);
        return inorderTraversal;
    }

    private void inorder(List<Object> res, TreeNode root) {
        if(root.left != null) inorder(res, root.left);
        res.add(root.val);
        if(root.right != null) inorder(res, root.right);
    }
}
