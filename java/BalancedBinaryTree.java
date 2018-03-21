public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        System.out.println(new BalancedBinaryTree().isBalanced(n1));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + height(root.right);
        } else if (root.right == null) {
            return 1 + height(root.left);
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
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
