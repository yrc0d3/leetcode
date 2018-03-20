public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
        System.out.println(root.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int leftPreorder, int rightPreorder,
                           int[] inorder, int leftInorder, int rightInorder) {
        if (leftPreorder > rightPreorder) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftPreorder]);
        int rootIndexInorder = findRootInorder(inorder, leftInorder, rightInorder, preorder[leftPreorder]);
        int leftLen = rootIndexInorder - leftInorder;
        root.left = helper(preorder, leftPreorder + 1, leftPreorder + leftLen, inorder, leftInorder, rootIndexInorder - 1);
        root.right = helper(preorder, leftPreorder + leftLen + 1, rightPreorder, inorder, rootIndexInorder + 1, rightInorder);
        return root;
    }

    public int findRootInorder(int[] inorder, int left, int right, int rootVal) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return right;
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
