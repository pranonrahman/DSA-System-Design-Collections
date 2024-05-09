package leetcodeProblems;

import java.util.Arrays;

/**
 * @author Raian Rahman
 * @since 2024.0.0
 */
public class MaximizeHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long count = 0;
        int selected = 0;
        for(int i=happiness.length-1; i>=Math.max(0, happiness.length-k); i--) {
            count+=Math.max(0, (happiness[i]-selected));
            selected++;
        }

        return count;
    }
}
