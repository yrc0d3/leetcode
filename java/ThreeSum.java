import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = new ThreeSum().threeSum(nums);
        for (List<Integer> list : ret) {
            System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return ret;
        }

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum > 0) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[left]);
                        solution.add(nums[right]);
                        ret.add(solution);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return ret;
    }
}
