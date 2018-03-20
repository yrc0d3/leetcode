public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
        System.out.println(root.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int leftInorder, int rightInorder,
                           int[] postorder, int leftPostorder, int rightPostorder) {
        if (leftPostorder > rightPostorder) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[rightPostorder]);
        int rootIndexInorder = findRootIndexInorder(inorder, leftInorder, rightInorder, root.val);
        int rightLen = rightInorder - rootIndexInorder;
        root.left = helper(inorder, leftInorder, rootIndexInorder - 1, postorder, leftPostorder, rightPostorder - rightLen - 1);
        root.right = helper(inorder, rootIndexInorder + 1, rightInorder, postorder, rightPostorder - rightLen, rightPostorder - 1);
        return root;
    }

    public int findRootIndexInorder(int[] inorder, int left, int right, int rootVal) {
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
