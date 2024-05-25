package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raian.rahman
 * @since 5/25/24
 */
public class WordBreak2 {

    class Solution {
        Trie trie = new Trie();
        List<String> result;

        public List<String> wordBreak(String s, List<String> wordDict) {
            result = new ArrayList();

            for (String string : wordDict) {
                trie.insertWord(string);
            }

            rec(s.toCharArray(), new StringBuilder(), new StringBuilder(), 0);

            return result;
        }

        private void rec(char[] s, StringBuilder current, StringBuilder currentWord, int pos) {
            if (pos == s.length) {
                if (trie.isWord(currentWord.toString())) {
                    result.add(current.toString());
                }

                return;
            }

            current.append(s[pos]);
            currentWord.append(s[pos]);

            if (trie.isWord(currentWord.toString())) {
                StringBuilder sb = new StringBuilder(current.toString());
                sb.append(' ');
                rec(s, sb, new StringBuilder(), pos + 1);
            }

            rec(s, current, currentWord, pos + 1);
        }
    }

    class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insertWord(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.children[ch - 'a'] == null) {
                    current.children[ch - 'a'] = new TrieNode();
                }

                current = current.children[ch - 'a'];
            }

            current.terminalNode = true;
        }

        public boolean isWord(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                if (current == null) {
                    return false;
                }

                current = current.children[ch - 'a'];
            }

            return current != null && current.terminalNode;
        }
    }

    class TrieNode {

        TrieNode[] children;
        boolean terminalNode;

        public TrieNode() {
            children = new TrieNode[26];
            terminalNode = false;
        }
    }
}
