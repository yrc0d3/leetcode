import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        // stores index
        // the bottom index has the shortest height
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])) {
                int h = heights[stack.pop()];
                int len = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, h * len);
            }
            // push when stack is empty or all the heights remaining in stack are shorter than current height
            stack.push(i);
        }
        return max;
    }
}
