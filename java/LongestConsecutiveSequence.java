import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                int count = 1;
                int next = nums[i] + 1;
                while (set.contains(next)) {
                    count++;
                    set.remove(next);
                    next++;
                }
                int prev = nums[i] - 1;
                while (set.contains(prev)) {
                    count++;
                    set.remove(prev);
                    prev--;
                }
                max = Math.max(max, count);
                set.remove(nums[i]);
            }
        }

        return max;
    }
}
