package Trees.Traversals;

import Trees.TreeNode;

public class inorderTraversal {


    public void traverse(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        //print 
        traverse(root.right);
    }
    
}
