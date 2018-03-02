public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        int maxJump = nums[0];
        for (int i = 1; i < nums.length - 1 && i <= maxJump; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
        }

        return maxJump >= nums.length - 1;
    }
}
