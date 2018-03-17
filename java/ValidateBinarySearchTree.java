import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    // in-order traversal
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                if (pre != null && root.val <= pre.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }

        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
