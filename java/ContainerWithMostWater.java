public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 1};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            ret = Math.max(ret, (right - left) * h);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ret;
    }
}
