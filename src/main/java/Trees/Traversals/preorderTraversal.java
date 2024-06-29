package Trees.Traversals;

import Trees.TreeNode;

public class preorderTraversal {


    public void traverse(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        //print
        traverse(root.left);
        traverse(root.right);
    }
    
}
