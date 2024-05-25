package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author raian.rahman
 * @since 5/25/24
 */
public class WordBreakIIWithoutTrie {

    List<String> result;
    Set<String> dict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList();
        dict = new HashSet<>();

        for (String string : wordDict) {
            dict.add(string);
        }

        rec(s.toCharArray(), new StringBuilder(), new StringBuilder(), 0);

        return result;
    }

    private void rec(char[] s, StringBuilder current, StringBuilder currentWord, int pos) {
        if (pos == s.length) {
            if (dict.contains(currentWord.toString())) {
                result.add(current.toString());
            }

            return;
        }

        current.append(s[pos]);
        currentWord.append(s[pos]);

        if (dict.contains(currentWord.toString())) {
            StringBuilder sb = new StringBuilder(current.toString());
            sb.append(' ');
            rec(s, sb, new StringBuilder(), pos + 1);
        }

        rec(s, current, currentWord, pos + 1);
    }
}
