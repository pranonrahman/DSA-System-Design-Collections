package leetcodeProblems;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Raian Rahman
 * @since 6/23/2024
 */
class Solution {
    public record Pair<K, V>(K key, V value) {
        // intentionally empty
    }


    public int longestSubarray(int[] nums, int limit) {
        Set<Pair<Integer, Integer>> small = new TreeSet<>((o1, o2) -> {
            if (Objects.equals(o1.key(), o2.key())) {
                return o1.value() - o2.value();
            }

            return o1.key() - o2.key();
        });

        Set<Pair<Integer, Integer>> large = new TreeSet<Pair<Integer, Integer>>((o1, o2) -> {
            if (Objects.equals(o1.key(), o2.key())) {
                return o1.value() - o2.value();
            }

            return o2.key() - o1.key();
        });

        int start = 0;
        int result = 1;

        small.add(new Pair<>(nums[start], start));
        large.add(new Pair<>(nums[start], start));

        for (int i = 1; i < nums.length; i++) {
            small.add(new Pair<>(nums[i], i));
            large.add(new Pair<>(nums[i], i));

            int smallest = small.stream().findFirst().get().key();
            int largest = large.stream().findFirst().get().key();

            while (start < i && largest - smallest > limit) {
                small.remove(new Pair<>(nums[start], start));
                large.remove(new Pair<>(nums[start], start));

                smallest = small.stream().findFirst().get().key();
                largest = large.stream().findFirst().get().key();
                start++;
            }

            result = Math.max(result, i - start + 1);
        }

        return result;
    }
}
