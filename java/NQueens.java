import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> ret = new NQueens().solveNQueens(4);
        ret.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println();
        });
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        bfs(ret, matrix, 0);
        return ret;
    }

    public void bfs(List<List<String>> ret, char[][] matrix, int row) {
        if (row == matrix.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                list.add(new String(matrix[i]));
            }
            ret.add(list);
            return;
        }

        for (int col = 0; col < matrix.length; col++) {
            matrix[row][col] = 'Q';
            if (isValid(matrix, row, col)) {
                bfs(ret, matrix, row + 1);
            }
            matrix[row][col] = '.';
        }
    }

    public boolean isValid(char[][] matrix, int row, int col) {
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == 'Q') {
                    if (j == col) {
                        return false;
                    }
                    // "\" 135 degree diagonals
                    int rightRow = i + 1, rightCol = j + 1;
                    while (rightRow < matrix.length && rightCol < matrix.length) {
                        if (matrix[rightRow][rightCol] == 'Q') {
                            return false;
                        }
                        rightRow++;
                        rightCol++;
                    }
                    // "/" 45 degree diagonals
                    int leftRow = i + 1;
                    int leftCol = j - 1;
                    while (leftRow < matrix.length && leftCol >= 0) {
                        if (matrix[leftRow][leftCol] == 'Q') {
                            return false;
                        }
                        leftRow++;
                        leftCol--;
                    }
                }
            }
        }

        return true;
    }
}
