package Trees;

public class diameter {

    int result = -1;

    public int dia(TreeNode<Integer> root) {
        if(root == null) {
            return -1;
        }
        dfs(root);
        return result;
    }

    public int dfs(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }


    public int height(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


    // leetcode answer
    // int result = -1;
    // public int diameterOfBinaryTree(TreeNode root) {
    //     dfs(root);
    //     return result;
    // }

    // private int dfs(TreeNode current) {
    //     if (current == null) {
    //         return -1;
    //     }
    //     int left = 1 + dfs(current.left);
    //     int right = 1 + dfs(current.right);
    //     result = Math.max(result, (left + right));
    //     return Math.max(left, right);
    // }



}
