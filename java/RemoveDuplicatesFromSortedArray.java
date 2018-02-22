public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int newLength = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[cur++] = nums[i];
            }
        }

        return cur;
    }
}
