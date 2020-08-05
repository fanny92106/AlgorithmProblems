package Graph;

import java.util.Arrays;

/**
 * Data structure used to check if there is a cycle in graph
 * This version is optimized with path compression 
 */
class UnionFind {
    int[] parent;
    int[] rank;

    // constructor
    public UnionFind(int len) {
        parent = new int[len];
        rank = new int[len];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
    }

    // find parent node
    public int find(int a) {
        while (parent[a] != -1) {
            a = parent[a];
        }
        return a;
    }

    // union disjoint parent nodes
    public boolean union(int a, int b) {
        int parentOfA = find(a);
        int parentOfB = find(b);
        // already in the connected nodes set
        if (parentOfA == parentOfB) {
            return false;
        }
        if (parentOfA > parentOfB) {
            parent[parentOfB] = parentOfA;
        } else if (parentOfA < parentOfB) {
            parent[parentOfA] = parentOfB;
        } else {
            parent[parentOfA] = parentOfB;
            rank[parentOfB]++;
        }
        return true;
    }
}