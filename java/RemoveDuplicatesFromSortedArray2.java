public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < 2 || nums[i] > nums[cur - 2]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
