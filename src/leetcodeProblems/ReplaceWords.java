package leetcodeProblems;

import templates.string.trie.Trie;

import java.util.List;

/**
 * @author Raian Rahman
 * @since 6/7/2024
 */
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (String word : dictionary) {
            trie.insert(word);
        }

        StringBuilder sb = new StringBuilder();

        String[] wordsInSentence = sentence.split(" ");

        for (String word : wordsInSentence) {
            String root = trie.getRootWord(word);

            if (root == null) {
                root = word;
            }

            sb.append(root);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
