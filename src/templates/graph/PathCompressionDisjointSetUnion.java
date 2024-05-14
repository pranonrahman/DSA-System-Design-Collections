package templates.graph;

/**
 * @author Raian Rahman
 * @since 5/14/2024
 */
public class PathCompressionDisjointSetUnion {

    int[] parent;

    public void makeSet(int v) {
        parent[v] = v;
    }

    int findSet(int v) {
        if(v==parent[v]) {
            return v;
        }

        /*
         * The simple implementation does what was intended:
         * first find the representative of the set (root vertex),
         * and then in the process of stack unwinding the visited
         * nodes are attached directly to the representative
         */
        return parent[v] = findSet(parent[v]);
    }

    void unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a!=b) {
            parent[b] = a;
        }
    }
}
