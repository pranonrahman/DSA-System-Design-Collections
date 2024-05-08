package leetcodeProblems;

import java.util.PriorityQueue;
/**
 * @author Raian Rahman
 * @since 2024.0.0
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for(int i=0; i< score.length; i++) {
            pq.add(new Pair(score[i], i));
        }

        int pos = 0;
        while(!pq.isEmpty()) {
            String positionString;

            switch (pos) {
                case 0:
                    positionString = "Gold Medal";
                    break;
                case 1:
                    positionString = "Silver Medal";
                    break;
                case 2:
                    positionString = "Bronze Medal";
                    break;
                default:
                    positionString = String.valueOf(pos+1);
            }

            result[(int)pq.poll().getValue()] = positionString;
            pos++;
        }

        return result;
    }
}
