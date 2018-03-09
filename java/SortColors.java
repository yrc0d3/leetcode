public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1, 2};
        new SortColors().sortColors(nums);
        for (int x : nums) {
            System.out.print(x + ",");
        }
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[right] == 2) {
                right--;
            } else {
                swap(nums, left++, right);
            }
        }
        if (nums[right] == 2) {
            right--;
        }
        left = 0;
        while (left < right) {
            if (nums[right] == 1) {
                right--;
            } else {
                swap(nums, left++, right);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
