package leetcodeProblems;

import java.util.Arrays;

/**
 * @author raian.rahman
 * @since 5/2/24
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length-1;

        while(lo<hi) {
            if(nums[lo]==-1*nums[hi]) {
                return nums[hi];
            } else if(nums[lo]*-1 < nums[hi]) {
                hi--;
            } else {
                lo++;
            }
        }

        return -1;
    }
}
