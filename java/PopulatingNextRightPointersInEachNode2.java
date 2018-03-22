public class PopulatingNextRightPointersInEachNode2 {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.right = new TreeLinkNode(3);
        new PopulatingNextRightPointersInEachNode2().connect(root);
        while (root != null) {
            TreeLinkNode tmp = root;
            while (root != null) {
                System.out.print(root.val + ",");
                root = root.next;
            }
            System.out.println();
            root = tmp;
            while (root != null && root.left == null && root.right == null) {
                root = root.next;
            }
            if (root != null) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null, prev = null;
        while (root != null) {
            while (root != null) {
                if (root.left != null) {
                    if (prev == null) {
                        head = root.left;
                    } else {
                        prev.next = root.left;
                    }
                    prev = root.left;
                }
                if (root.right != null) {
                    if (prev == null) {
                        head = root.right;
                    } else {
                        prev.next = root.right;
                    }
                    prev = root.right;
                }
                root = root.next;
            }
            root = head;
            prev = null;
            head = null;
        }
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
