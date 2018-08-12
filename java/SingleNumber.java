public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret = ret ^ n;
        }
        return ret;
    }
}
