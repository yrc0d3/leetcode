import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ret = new CombinationSum2().combinationSum2(candidates, target);
        for (List<Integer> list : ret) {
            for (Integer n : list) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length == 0 || candidates[0] > target) {
            return ret;
        }

        helper(candidates, target, 0, new ArrayList<>(), ret);
        return ret;
    }

    public void helper(int[] candidates, int remain, int index, List<Integer> list, List<List<Integer>> ret) {
        if (remain == 0) {
            ret.add(new ArrayList<>(list));
            return;
        } else if (remain < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i == index || candidates[i] != candidates[i - 1]) {
                    list.add(candidates[i]);
                    helper(candidates, remain - candidates[i], i + 1, list, ret);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
