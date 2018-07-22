public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            helper(board, i, 0, 0);
        }
        for (int j = 1; j < board[0].length; j++) {
            helper(board, 0, j, 1);
        }
        for (int i = 1; i < board.length; i++) {
            helper(board, i, board[0].length - 1, 2);
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            helper(board, board.length - 1, j, 3);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void helper(char[][] board, int row, int col, int direction) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = '1';
            if (direction == 0) {
                // right
                helper(board, row, col + 1, 0);
                helper(board, row + 1, col, 1);
                helper(board, row - 1, col, 3);
            } else if (direction == 1) {
                // down
                helper(board, row, col + 1, 0);
                helper(board, row + 1, col, 1);
                helper(board, row, col - 1, 2);
            } else if (direction == 2) {
                // left
                helper(board, row + 1, col, 1);
                helper(board, row, col - 1, 2);
                helper(board, row - 1, col, 3);
            } else {
                // up
                helper(board, row, col + 1, 0);
                helper(board, row, col - 1, 2);
                helper(board, row - 1, col, 3);
            }
        }
    }
}
