import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> ret = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
        ret.forEach(list -> {
            list.forEach(val -> System.out.print(val + ","));
            System.out.println();
        });
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int flag = 1;
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> list = new ArrayList<>();
            if (flag % 2 == 1) {
                for (int i = 0; i < count; i++) {
                    TreeNode node = deque.pollFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    list.add(node.val);
                }
            } else {
                for (int i = 0; i < count; i++) {
                    TreeNode node = deque.pollLast();
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    list.add(node.val);
                }
            }
            ret.add(list);
            flag++;
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
