import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        List<List<Integer>> ret = new PathSum2().pathSum(root, 2);
        ret.forEach(list -> {
            list.forEach(i -> System.out.print(i + ","));
            System.out.println();
        });
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        helper(ret, new ArrayList<>(), root, sum);
        return ret;
    }

    public void helper(List<List<Integer>> ret, List<Integer> list, TreeNode root, int sum) {
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ret.add(new ArrayList<>(list));
            }
        } else if (root.left == null) {
            helper(ret, list, root.right, sum);
        } else if (root.right == null) {
            helper(ret, list, root.left, sum);
        } else {
            helper(ret, list, root.left, sum);
            helper(ret, list, root.right, sum);
        }
        list.remove(list.size() - 1);
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
