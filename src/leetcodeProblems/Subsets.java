package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raian Rahman
 * @since 5/21/2024
 */
public class Subsets {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        rec(nums, 0, new ArrayList<>());

        return result;
    }

    private void rec(int[] nums, int pos, List<Integer> current) {
        if (pos == nums.length) {
            result.add(current);
            return;
        }

        List<Integer> keep = new ArrayList<>(current);
        keep.add(nums[pos]);

        rec(nums, pos + 1, current);
        rec(nums, pos + 1, keep);
    }
}
