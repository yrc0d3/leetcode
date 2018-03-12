import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    // use Largest Rectangle in Histogram's idea while updating heights row by row
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n + 1];
        for (int i = 0; i < m; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j <= n; j++) {
                if (j == n || matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }

                while (!stack.isEmpty() && (j == n || heights[stack.peek()] >= heights[j])) {
                    int h = heights[stack.pop()];
                    int len = stack.isEmpty() ? j : (j - stack.peek() - 1);
                    max = Math.max(max, h * len);
                }
                stack.push(j);
            }
        }

        return max;
    }
}
