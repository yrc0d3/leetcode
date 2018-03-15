import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        new BinaryTreeInorderTraversal().inorderTraversal(n1).forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        recursive(root, ret);
        return ret;
    }

    public void recursive(TreeNode root, List<Integer> ret) {
        if (root != null) {
            recursive(root.left, ret);
            ret.add(root.val);
            recursive(root.right, ret);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
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
