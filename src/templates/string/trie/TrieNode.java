package templates.string.trie;

/**
 * @author Raian Rahman
 * @since 5/27/2024
 */
public class TrieNode {

    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}
