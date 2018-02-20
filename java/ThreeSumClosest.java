import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - ret) > Math.abs(target - sum)) {
                        ret = sum;
                    }
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
                        return target;
                    }
                }
            }
        }

        return ret;
    }
}
