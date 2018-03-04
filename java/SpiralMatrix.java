import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> ret = new SpiralMatrix().spiralOrder(matrix);
        ret.forEach(i -> System.out.print(i + ","));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int[][] directionMatrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ret = new ArrayList<>(m * n);
        int[] moveRange = {n, m - 1};
        int direction = 0;
        int row = 0, col = -1;
        while (moveRange[direction % 2] > 0) {
            for (int i = 0; i < moveRange[direction % 2]; i++) {
                row += directionMatrix[direction][0];
                col += directionMatrix[direction][1];
                ret.add(matrix[row][col]);
            }
            moveRange[direction % 2] -= 1;
            direction = (direction + 1) % 4;
        }

        return ret;
    }
}
