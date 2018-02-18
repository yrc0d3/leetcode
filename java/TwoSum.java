import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] ret = twoSum.twoSum(nums, target);
        System.out.println(ret[0] + "," + ret[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ret[0] = map.get(nums[i]);
                ret[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return ret;
    }
}