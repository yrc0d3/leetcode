public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    }
}
