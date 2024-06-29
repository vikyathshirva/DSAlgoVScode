package Trees.Traversals;

import Trees.TreeNode;

public class postorderTraversal {

    public void traverse(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        //print

    }
    
}
