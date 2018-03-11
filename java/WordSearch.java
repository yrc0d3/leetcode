public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "DFA";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int row, int col, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] == '*' || board[row][col] != word.charAt(pos)) {
            return false;
        }
        board[row][col] = '*';
        boolean ret = helper(board, row + 1, col, word, pos + 1) ||
                helper(board, row, col + 1, word, pos + 1) ||
                helper(board, row - 1, col, word, pos + 1) ||
                helper(board, row, col - 1, word, pos + 1);
        board[row][col] = word.charAt(pos);
        return ret;
    }
}
