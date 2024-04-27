package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Raian Rahman
 * @since 4/27/2024
 */
public class FreedomTrail {

    int[][] memo;
    int ringLength;
    int keyLength;
    Map<Character, List<Integer>> hashTable;

    public int findRotateSteps(String ring, String key) {
        hashTable = new HashMap();
        ringLength = ring.length();
        keyLength = key.length();

        int index = 0;
        for (char ch : ring.toCharArray()) {
            if (!hashTable.containsKey(ch)) {
                hashTable.put(ch, new ArrayList());
            }
            hashTable.get(ch).add(index++);
        }

        memo = new int[ringLength][keyLength];

        return dp(ring.toCharArray(), key.toCharArray(), 0, 0);
    }

    private int dp(char[] ring, char[] key, int ringPos, int keyPos) {
        if (keyLength == keyPos) {
            return 0;
        }

        if (memo[ringPos][keyPos] != 0) {
            return memo[ringPos][keyPos];
        }


        int ans = Integer.MAX_VALUE;

        for (int index : hashTable.get(key[keyPos])) {
            ans = Math.min(ans, getDistance(ringPos, index) + dp(ring, key, index, keyPos + 1));
        }

        return memo[ringPos][keyPos] = ans;
    }

    private int getDistance(int currentPos, int targetPos) {
        int absDist = Math.abs(targetPos - currentPos);
        return 1 + Math.min(
                absDist,
                ringLength - absDist
        );
    }
}
