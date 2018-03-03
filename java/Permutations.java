import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = new Permutations().permute(nums);
        ret.forEach((list) -> {
            list.forEach((i) -> System.out.print(i + ","));
            System.out.println();
        });
    }

    // bfs
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }

        helper(ret, new ArrayList<>(), nums);
        return ret;
    }

    public void helper(List<List<Integer>> ret, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            ret.add(new ArrayList<>(tmpList));
            return;
        }

        for (int x : nums) {
            if (tmpList.contains(x)) {
                continue;
            }
            tmpList.add(x);
            helper(ret, tmpList, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    // using nextPermutation
    public List<List<Integer>> permute2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }

        ret.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        nextPermutation(nums, ret);
        return ret;
    }

    public void nextPermutation(int[] nums, List<List<Integer>> ret) {
        int maxIndexFromRight = nums.length - 1;
        while (maxIndexFromRight > 0 && nums[maxIndexFromRight] <= nums[maxIndexFromRight - 1]) {
            maxIndexFromRight--;
        }
        if (maxIndexFromRight == 0) {
            return;
        }
        int swapIndex = nums.length - 1;
        while (swapIndex > maxIndexFromRight && nums[swapIndex] <= nums[maxIndexFromRight - 1]) {
            swapIndex--;
        }
        swap(nums, maxIndexFromRight - 1, swapIndex);
        reverse(nums, maxIndexFromRight, nums.length - 1);
        ret.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        nextPermutation(nums, ret);
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
