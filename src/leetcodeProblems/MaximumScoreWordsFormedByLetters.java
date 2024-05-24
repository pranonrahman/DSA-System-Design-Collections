package leetcodeProblems;

/**
 * @author raian.rahman
 * @since 5/24/24
 */
public class MaximumScoreWordsFormedByLetters {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] wordFreq = new int[26];

        for (char ch : letters) {
            wordFreq[ch - 'a']++;
        }


        return dp(words, 0, wordFreq, score);
    }

    private int dp(String[] words, int i, int[] wordFreq, int[] score) {
        if (i == words.length) {
            return 0;
        }

        int keep = 0;

        if (checkValidity(words[i], wordFreq)) {
            int[] keepWordFreq = wordFreq.clone();
            keep = calculateScoreAndRemoveLetter(words[i], score, keepWordFreq) + dp(words, i + 1, keepWordFreq, score);
        }


        int[] newWordFreq = wordFreq.clone();
        int skip = dp(words, i + 1, newWordFreq, score);

        return Math.max(keep, skip);
    }

    private int calculateScoreAndRemoveLetter(String word, int[] score, int[] wordFreq) {
        int wordScore = 0;

        for (char ch : word.toCharArray()) {
            wordScore += score[ch - 'a'];
            wordFreq[ch - 'a']--;
        }

        return wordScore;
    }

    private boolean checkValidity(String word, int[] wordFreq) {
        int[] newWordFreq = wordFreq.clone();

        for (char ch : word.toCharArray()) {
            if (newWordFreq[ch - 'a'] == 0) {
                return false;
            }

            newWordFreq[ch - 'a']--;
        }

        return true;
    }
}
