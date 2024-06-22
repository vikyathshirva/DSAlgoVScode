package Trees;

public class diameter {

    int result = -1;
    public int findDiameter(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right);

    }

}
