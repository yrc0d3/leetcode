import java.util.*;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> ret = new BinaryTreePostorderTraversal().postorderTraversal(root);
        for (Integer n : ret) {
            System.out.printf("%d,", n);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.right == null || visited.contains(root)) {
                    ret.add(root.val);
                    root = null;
                } else {
                    visited.add(root);
                    stack.push(root);
                    root = root.right;
                }
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
