public class SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = new SpiralMatrix2().generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] directionMatrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] moveRange = {n, n - 1};
        int direction = 0;
        int row = 0, col = -1;
        int count = 1;
        while (moveRange[direction % 2] > 0) {
            for (int i = 0; i < moveRange[direction % 2]; i++) {
                row += directionMatrix[direction][0];
                col += directionMatrix[direction][1];
                matrix[row][col] = count++;
            }
            moveRange[direction % 2] -= 1;
            direction = (direction + 1) % 4;
        }

        return matrix;
    }
}
