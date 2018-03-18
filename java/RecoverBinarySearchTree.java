public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        new RecoverBinarySearchTree().recoverTree(root);
    }

    // in-order morris traversal
    public void recoverTree(TreeNode root) {
        TreeNode pre = null, cur = root;
        TreeNode first = null, second = null;
        while (cur != null) {
            if (cur.left == null) {
                // start of change part
                if (pre != null && pre.val > cur.val) {
                    if (first == null) {
                        first = pre;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                pre = cur;
                // end of change part
                cur = cur.right;
            } else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    // start of change part
                    if (pre != null && pre.val > cur.val) {
                        if (first == null) {
                            first = pre;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    pre = cur;
                    // end of change part
                    tmp.right = null;
                    cur = cur.right;
                }
            }
        }
        int tmpVal = first.val;
        first.val = second.val;
        second.val = tmpVal;
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
