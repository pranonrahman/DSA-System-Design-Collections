package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 2024.0.0
 */
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    public int minOperations(int[] nums, int k) {
        int xorValue = 0;

        for(int num: nums) {
            xorValue ^= num;
        }

        return getDiff(k, xorValue);
    }

    private int getDiff(int k, int xorValue) {
        int count = 0;

        while(!(xorValue==0 && k==0)) {
            if(xorValue%2!=k%2) {
                count++;
            }
            xorValue/=2;
            k/=2;
        }

        return count;
    }
}
