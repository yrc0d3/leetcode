public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame2().jump2(nums));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] need = new int[nums.length];
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] > maxJump) {
                for (int j = maxJump + 1; j < nums.length && j <= i + nums[i]; j++) {
                    need[j] = need[i] + 1;
                }
                maxJump = i + nums[i];
            }
        }

        return need[nums.length - 1];
    }

    public int jump2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int i = 0, currentMax = 0, nextMax = 0, level = 0;
        while (currentMax - i + 1 > 0) {
            level++;
            while (i <= currentMax) {
                nextMax = Math.max(nextMax, i + nums[i]);
                if (nextMax >= nums.length - 1) {
                    return level;
                }
                i++;
            }
            currentMax = nextMax;
        }

        return level;
    }
}
