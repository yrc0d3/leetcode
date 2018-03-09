public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1},
                {1, 1, 1}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;
        // matrix[i][0] represents whether row i's elements should be set to 0, 0 <= i <= m-1
        // matrix[0][j] represents whether col j's elements should be set to 0, 1 <= j <= n-1
        // col0 represents whether col 0's elements should be set to 0
        int col0 = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}
