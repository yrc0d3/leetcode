public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[2];
        nums1[0] = 2;
        int[] nums2 = new int[1];
        nums2[0] = 1;
        new MergeSortedArray().merge(nums1, 1, nums2, 1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
