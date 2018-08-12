public class SingleNumber2 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new SingleNumber2().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum = sum % 3;
                }
            }
            if (sum > 0) {
                ret = ret | (sum << i);
            }
        }

        return ret;
    }

    public int singleNumber2(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;

        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }

        return x1;  // Since p = 1, in binary form p = '01', then p1 = 1, so we should return x1.
        // If p = 2, in binary form p = '10', then p2 = 1, and we should return x2.
        // Or alternatively we can simply return (x1 | x2).
    }
}
