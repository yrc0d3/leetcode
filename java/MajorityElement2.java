import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> ret = new MajorityElement2().majorityElement(nums);
        ret.forEach(System.out::println);
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;
        for (int n : nums) {
            if (n == n1) {
                c1++;
            } else if (n == n2) {
                c2++;
            } else if (c1==0) {
                n1 = n;
                c1++;
            } else if (c2 == 0) {
                n2 = n;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1=0;
        c2=0;
        for (int n : nums) {
            if (n == n1) {
                c1++;
            } else if (n == n2) {
                c2++;
            }
        }

        List<Integer> ret = new ArrayList<>();
        if (c1 > nums.length / 3) {
            ret.add(n1);
        }
        if (c2 > nums.length / 3) {
            ret.add(n2);
        }

        return ret;
    }
}
