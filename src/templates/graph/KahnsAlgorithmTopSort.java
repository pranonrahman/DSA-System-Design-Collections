package templates.graph;

import java.util.*;

/**
 * @author Raian Rahman
 * @since 4/23/2024
 */
public class KahnsAlgorithmTopSort {

    public static List<Integer> runTopSort(int nodes, Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        Deque<Integer> leaveNodes = new ArrayDeque<>();

        //Populating the edge-count, degree of each node
        for (int i = 0; i < nodes; i++) {
            edgeCount.put(i, graph.get(i).size());

            if (graph.get(i).size() == 1) {
                leaveNodes.addLast(i);
            }
        }

        List<Integer> sortedList = new ArrayList<>();

        //Starting from one of the leaf node
        //First cover the leaf nodes and then add which nodes can be processed
        while (!leaveNodes.isEmpty()) {
            int node = leaveNodes.pollFirst();
            sortedList.add(node);

            for (int neighbour : graph.get(node)) {
                edgeCount.put(neighbour, edgeCount.get(neighbour)-1);

                if (edgeCount.get(neighbour) == 1) {
                    leaveNodes.addLast(neighbour);
                }
            }
        }

        return sortedList;
    }

    //driver code
    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i <= 5; i++) {
            graph.put(i, new ArrayList<>());
        }

        graph.get(3).add(0);
        graph.get(0).add(3);
        graph.get(3).add(1);
        graph.get(1).add(3);
        graph.get(3).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);

        List<Integer> sortedList = runTopSort(6, graph);

        for (Integer node : sortedList) {
            System.out.print(node + " ");
        }
    }
}
