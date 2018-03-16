import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    public static void main(String[] args) {
        new UniqueBinarySearchTrees2().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int index = start; index <= end; index++) {
            List<TreeNode> leftList = helper(start, index - 1);
            List<TreeNode> rightList = helper(index + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(index);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }

        return list;
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
