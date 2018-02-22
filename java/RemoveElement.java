public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int newLen = new RemoveElement().removeElement(nums, val);
        for (int i = 0; i < newLen; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[begin++] = nums[i];
            }
        }

        return begin;
    }
}
