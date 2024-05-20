package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 2024.0.0
 */
public class SumOfAllSubsetsXORTotals {

    public int subsetXORSum(int[] nums) {
        return rec(nums, 0, 0);
    }

    public int rec(int[] nums, int pos, int currentSum) {
        if (pos == nums.length) {
            return 0;
        }
        int keepPos = currentSum ^ nums[pos];

        return keepPos + rec(nums, pos + 1, keepPos) + rec(nums, pos + 1, currentSum);
    }
}
