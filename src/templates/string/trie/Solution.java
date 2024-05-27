package templates.string.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raian Rahman
 * @since 5/27/2024
 */
public class Solution {

    List<String> result;
    Trie trie;

    public List<String> wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        result = new ArrayList<>();

        for (String word : wordDict) {
            trie.insert(word);
        }

        dp(s.toCharArray(), new StringBuilder(), new StringBuilder(), 0, trie.getRoot());

        return result;
    }

    private void dp(char[] str, StringBuilder current, StringBuilder currentWord, int index, TrieNode currentNode) {
        if (index == str.length) {
            if (trie.isValidWord(currentWord.toString())) {
                result.add(currentWord.toString());
            }

            return;
        }

        do {
            current.append(str[index]);
            currentWord.append(str[index]);
            currentNode = currentNode.children[str[index] - 'a'];

            if (currentNode == null) {
                return;
            }

            if (currentNode.isWord) {
                StringBuilder sb = new StringBuilder(current.toString());
                sb.append(' ');

                dp(str, sb, new StringBuilder(), index + 1, trie.getRoot());
                dp(str, current, currentWord, index + 1, currentNode);
                return;
            }

            index++;
        } while (index < str.length);
    }
}
