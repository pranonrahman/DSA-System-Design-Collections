package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 4/25/2024
 */
public class LongestIdealSubsequence {

    int[][] memo;

    public int longestIdealString(String s, int k) {
        memo = new int[s.length()][255];

        return dp(s.toCharArray(), k, 0, '#');
    }

    private int dp(char[] str, int k, int pos, char prev) {
        if (pos >= str.length) {
            return 0;
        }

        if (memo[pos][prev] != 0) {
            return memo[pos][prev];
        }

        int keep = 0;
        if ((Math.abs(prev - str[pos]) <= k) || prev == '#') {
            keep = 1 + dp(str, k, pos + 1, str[pos]);
        }

        int skip = dp(str, k, pos + 1, prev);

        return memo[pos][prev] = Math.max(keep, skip);
    }
}
