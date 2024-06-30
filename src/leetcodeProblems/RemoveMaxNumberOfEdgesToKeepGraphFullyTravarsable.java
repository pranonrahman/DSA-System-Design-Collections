package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 6/30/2024
 */
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTravarsable {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (alice.findSet(edge[1]) == alice.findSet(edge[2]) || bob.findSet(edge[1]) == bob.findSet(edge[2])) {
                    count++;
                }

                alice.unionSets(edge[1], edge[2]);
                bob.unionSets(edge[1], edge[2]);
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (alice.findSet(edge[1]) == alice.findSet(edge[2])) {
                    count++;
                }
                alice.unionSets(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                if (bob.findSet(edge[1]) == bob.findSet(edge[2])) {
                    count++;
                }
                bob.unionSets(edge[1], edge[2]);
            }
        }

        if (alice.component > 1 || bob.component > 1) {
            return -1;
        }

        return count;
    }

    static class DSU {

        int[] parent;
        int[] depth;
        int component;

        DSU(int n) {
            component = n;
            parent = new int[n + 1];
            depth = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                makeSet(i);
            }
        }

        public void makeSet(int v) {
            parent[v] = v;
            depth[v] = 0;
        }

        int findSet(int v) {
            if (v == parent[v]) {
                return v;
            }

            return parent[v] = findSet(parent[v]);
        }

        void unionSets(int a, int b) {
            a = findSet(a);
            b = findSet(b);

            if (a == b) {
                return;
            }

            if (depth[a] < depth[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            parent[b] = a;
            if (depth[a] == depth[b]) {
                depth[a]++;
            }

            component--;
        }
    }
}
