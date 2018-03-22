public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        new PopulatingNextRightPointersInEachNode().connect(root);
        while (root != null) {
            TreeLinkNode tmp = root.left;
            while (root != null) {
                System.out.print(root.val + ",");
                root = root.next;
            }
            System.out.println();
            root = tmp;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        while (root.left != null) {
            TreeLinkNode tmp = root.left;
            while (root != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                root = root.next;
            }
            root = tmp;
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
