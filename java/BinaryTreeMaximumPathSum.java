public class BinaryTreeMaximumPathSum {

    private int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));
        maxValue = Math.max(maxValue, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
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
