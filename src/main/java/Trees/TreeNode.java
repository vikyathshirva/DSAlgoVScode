package Trees;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.data = val;
        this.left = null;
        this.right= null;
    }
}
