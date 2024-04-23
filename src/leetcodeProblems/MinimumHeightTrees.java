package leetcodeProblems;

import java.util.*;

/**
 * @author Raian Rahman
 * @since 4/23/2024
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            return Collections.singletonList(0);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> leaves = new ArrayDeque<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(graph.get(i).size()==1) {
                leaves.addLast(i);
            }

            edgeCount.put(i, graph.get(i).size());
        }

        while(!leaves.isEmpty()) {
            if(n<=2) {
                return new ArrayList<>(leaves);
            }

            int sz = leaves.size();
            for(int i=0; i<sz; i++) {
                int node = leaves.pollFirst();
                n--;

                for(int neighbour: graph.get(node)) {
                    edgeCount.put(neighbour, edgeCount.get(neighbour)-1);

                    if(edgeCount.get(neighbour)==1) {
                        leaves.addLast(neighbour);
                    }
                }
            }
        }

        return new ArrayList<>();
    }
}
