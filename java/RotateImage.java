public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("raw matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        new RotateImage().rotate(matrix);
        System.out.println("new matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int maxIndex = matrix.length - 1;
        for (int level = 0; level < matrix.length / 2; level++) {
            for (int i = level; i < maxIndex - level; i++) {
                int tmp = matrix[level][i];
                matrix[level][i] = matrix[maxIndex - i][level];
                matrix[maxIndex - i][level] = matrix[maxIndex - level][maxIndex - i];
                matrix[maxIndex - level][maxIndex - i] = matrix[i][maxIndex - level];
                matrix[i][maxIndex - level] = tmp;
            }
        }
    }
}
