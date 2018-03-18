public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(new SymmetricTree().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null) {
            return n2 == null;
        }
        if (n2 == null) {
            return n1 == null;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return helper(n1.left, n2.right) && helper(n1.right, n2.left);
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
