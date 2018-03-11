public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 5, 1, 2, 2};
        int target = 6;
        System.out.println(new SearchInRotatedSortedArray2().search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target){
                return true;
            } else if (nums[mid] > nums[lo]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo++;
            }
        }

        return nums[lo] == target;
    }
}
