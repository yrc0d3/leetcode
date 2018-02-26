public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    int cubeIndex = i / 3 * 3 + j / 3;
                    if (row[i][n] || col[j][n] || cube[cubeIndex][n]) {
                        return false;
                    } else {
                        row[i][n] = true;
                        col[j][n] = true;
                        cube[cubeIndex][n] = true;
                    }
                }
            }
        }

        return true;
    }
}
