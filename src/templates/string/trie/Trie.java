package templates.string.trie;

/**
 * @author Raian Rahman
 * @since 5/27/2024
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }

            current = current.children[ch - 'a'];
        }

        current.isWord = true;
    }

    public boolean isValidWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (current == null) {
                return false;
            }

            current = current.children[ch - 'a'];
        }

        return current != null && current.isWord;
    }

    public String getRootWord(String word) {
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            sb.append(ch);

            current = current.children[ch - 'a'];

            if (current == null) {
                return null;
            }

            if(current.isWord) {
                return sb.toString();
            }
        }

        return sb.toString();
    }

    public TrieNode getRoot() {
        return this.root;
    }
}

