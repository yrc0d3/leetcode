public class FirstMissingPositive {
    public static void main(String[] args) {
//        int[] nums = {3, 4, -1, 1};
        int[] nums = {1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] <= nums.length) {
                if (nums[index] == index + 1 || nums[nums[index] - 1] == nums[index]) {
                    index++;
                } else {
                    int tmp = nums[nums[index] - 1];
                    nums[nums[index] - 1] = nums[index];
                    nums[index] = tmp;
                }
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
