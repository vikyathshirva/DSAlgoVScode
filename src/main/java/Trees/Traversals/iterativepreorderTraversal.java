package Trees.Traversals;

import java.util.ArrayDeque;
import java.util.Deque;

import Trees.TreeNode;

public class iterativepreorderTraversal {

    public void traverse(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            //print node.data

            if(node.right!= null) {
                stack.push(node.right);
            }
            if(node.left!= null) {
                stack.push(node.left);
            }
        }
    }
    
}
