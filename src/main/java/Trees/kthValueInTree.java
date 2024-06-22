package Trees;

import java.util.ArrayList;
import java.util.List;

public class kthValueInTree {

    public int kTh(TreeNode<Integer> root,int k) {
        List<Integer> result = new ArrayList<>();
        inOrderTrav(result,root);
        return result.get(k-1);
    }

    public void inOrderTrav(List<Integer> result, TreeNode<Integer> root) {
        if(root == null) {
            return ;
        }

        inOrderTrav(result, root.left);
        result.add(root.data);
        inOrderTrav(result, root.right);
    }
    
}
