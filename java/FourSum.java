import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ret = new FourSum().fourSum(nums, target);
        for (List<Integer> list : ret) {
            System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3));
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> tmp = threeSum(nums, i + 1, target - nums[i]);
                for (List<Integer> list : tmp) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[i]);
                    solution.addAll(list);
                    ret.add(solution);
                }
            }
        }

        return ret;
    }

    public List<List<Integer>> threeSum(int[] nums, int index, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = index; i < nums.length - 2; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum > target) {
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
