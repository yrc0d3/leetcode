public class SudokuSolver {

    boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    int cubeIndex = i / 3 * 3 + j / 3;
                    row[i][n] = col[j][n] = cube[cubeIndex][n] = true;
                }
            }
        }
        helper(board, 0, 0);
    }

    public boolean helper(char[][] board, int i, int j) {
        if (board[i][j] != '.') {
            if (i == 8 && j == 8) {
                return true;
            }
            int nextI = j == 8 ? i + 1 : i, nextJ = j == 8 ? 0 : j + 1;
            if (helper(board, nextI, nextJ)) {
                return true;
            } else {
                return false;
            }
        } else {
            for (int k = 0; k < 9; k++) {
                int cubeIndex = i / 3 * 3 + j / 3;
                if (row[i][k] || col[j][k] || cube[cubeIndex][k]) {
                    continue;
                } else {
                    board[i][j] = (char) ('1' + k);
                    row[i][k] = col[j][k] = cube[cubeIndex][k] = true;
                    if (i == 8 && j == 8) {
                        return true;
                    }
                    int nextI = j == 8 ? i + 1 : i, nextJ = j == 8 ? 0 : j + 1;
                    if (helper(board, nextI, nextJ)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        row[i][k] = col[j][k] = cube[cubeIndex][k] = false;
                    }
                }
            }

            return false;
        }
    }
}
