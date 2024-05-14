package templates.graph;

/**
 * @author Raian Rahman
 * @since 5/14/2024
 */
/*
 * It is easy to construct an example, so that the trees degenerate into long chains.
 * In that case, each find call will take O(n) time
 */
public class NaiveDisjointSetUnion {

    int[] parent;

    public void makeSet(int v) {
        parent[v] = v;
    }

    int findSet(int v) {
        if(v==parent[v]) {
            return v;
        }

        // It might lead to O(n)
        return findSet(parent[v]);
    }

    void unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a!=b) {
            parent[b] = a;
        }
    }
}
