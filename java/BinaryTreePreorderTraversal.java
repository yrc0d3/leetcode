import java.util.*;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> ret = new BinaryTreePreorderTraversal().preorderTraversal(root);
        for (Integer n : ret) {
            System.out.printf("%d,", n);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ret.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            } else {
                root = stack.pop();
            }
        }

        return ret;
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
