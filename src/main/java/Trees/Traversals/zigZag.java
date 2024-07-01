package Trees.Traversals;
import Trees.TreeNode;
import java.util.*;

public class zigZag {

    public List<List<Integer>> zigZagOrder(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode<Integer>> q = new ArrayDeque<>();
        q.offer(root);

        boolean ltor = true; 
        while(!q.isEmpty()) {
            int size = q.size(); 
            List<Integer> tempList = new ArrayList<>();
            int[] temp = new int[size];
            for(int i=0;i<size;i++) {
                TreeNode<Integer> node = q.poll();
                int idx = ltor ? 0 : size-1-i;
                temp[idx] = node.data;
                if(node.left!= null) {
                    q.offer(node.left);
                }
                if(node.right!= null) {
                    q.offer(node.right);
                }
            }
            ltor = !ltor;
            for(int n : temp) {
                tempList.add(n);
            }
            res.add(tempList);
        }

        return res;
    }
    
}
