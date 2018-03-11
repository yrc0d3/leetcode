import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> ret = new WordSearch2().findWords(board, words);
        ret.forEach(System.out::println);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, new StringBuilder(), trie, set);
            }
        }
        return new ArrayList<>(set);
    }

    public void helper(char[][] board, int row, int col, StringBuilder sb, Trie trie, Set<String> set) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '*') {
            return;
        }
        if (!trie.startsWith(sb.toString())) {
            return;
        }
        sb.append(board[row][col]);
        if (trie.search(sb.toString())) {
            set.add(sb.toString());
        }
        board[row][col] = '*';
        helper(board, row + 1, col, sb, trie, set);
        helper(board, row, col + 1, sb, trie, set);
        helper(board, row - 1, col, sb, trie, set);
        helper(board, row, col - 1, sb, trie, set);
        board[row][col] = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
