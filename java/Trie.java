public class Trie {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
        System.out.println(obj.search("word"));
        System.out.println(obj.startsWith("wo"));
    }

    private TrieNode head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = head;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.branches[pos] == null) {
                node.branches[pos] = new TrieNode();
            }
            node = node.branches[pos];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node == null ? false : node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node == null ? false : true;
    }

    private TrieNode findNode(String word) {
        TrieNode node = head;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.branches[pos] == null) {
                return null;
            }
            node = node.branches[pos];
        }
        return node;
    }

    private static class TrieNode {
        boolean isWord = false;
        TrieNode[] branches = new TrieNode[26];
    }
}
