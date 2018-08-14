public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 1, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur) {
                count--;
            } else {
                count++;
            }
            if (count < 0) {
                cur = nums[i];
                count = 1;
            }
        }

        return cur;
    }
}
