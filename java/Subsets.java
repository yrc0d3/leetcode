import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = new Subsets().subsets(nums);
        ret.forEach(list -> {
            list.forEach(num -> System.out.print(num + ","));
            System.out.println();
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    public void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> ret) {
        ret.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
