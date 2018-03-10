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
        if (index == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        helper(nums, index + 1, list, ret);
        list.remove(list.size() - 1);
        helper(nums, index + 1, list, ret);
    }
}
