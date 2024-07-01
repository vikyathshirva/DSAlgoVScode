package Trees.Traversals;

import java.util.LinkedList;
import java.util.Queue;
import Trees.TreeNode;

public class levelorderTraversal {


    public void traverse(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();
            //print node.data;
            int size = q.size();
            for(int i=0;i<size;i++) {
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

    }

    
}
