import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ret = new CombinationSum().combinationSum(candidates, target);
        for (List<Integer> list : ret) {
            for (Integer n : list) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length == 0 || candidates[0] > target) {
            return ret;
        }

        helper(candidates, target, 0, 0, new ArrayList<>(), ret);
        return ret;
    }

    public void helper(int[] candidates, int target, int index, int sum, List<Integer> list, List<List<Integer>> ret) {
        if (sum == target) {
            ret.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                helper(candidates, target, i, sum + candidates[i], list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
}
