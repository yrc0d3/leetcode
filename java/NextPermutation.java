public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new NextPermutation().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int index = nums.length - 1;
        while (index > 0 && nums[index] <= nums[index - 1]) {
            index--;
        }

        if (index == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int right = nums.length - 1;
        while (right >= index && nums[right] <= nums[index - 1]) {
            right--;
        }
        swap(nums, index - 1, right);
        reverse(nums, index, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }
}
