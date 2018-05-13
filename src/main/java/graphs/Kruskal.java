package graphs;

import java.util.Arrays;
import java.util.Scanner;

// Finding the min weight ostov of the given graph
// graph is given by array of its edges

public class Kruskal {

    private static int [] parent;
    private static int [] rank;

    private static void makeSet(int v) {
        parent[v] = v;
        rank[v] = 0;
    }

    private static int getSet(int v) {
        if (v == parent[v])
            return v;
        return parent[v] = getSet(parent[v]);
    }

    private static void unionSets(int u, int v) {
        u = getSet(u);
        v = getSet(v);
        if (u != v) {
            if (rank[u] < rank[v]) {
                int t = u;
                u = v;
                v = t;
            }
            parent[v] = u;

            if (rank[u] == rank[v])
                rank[u]++;
        }
    }

    public static class Edge implements Comparable <Edge> {
        int u, v, cost;
        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    private static int kruskal(Edge[] edges) {
        Arrays.sort(edges);

        int ostovWeight = 0;
        for (Edge edge : edges) {
            int v = edge.v;
            int u = edge.u;
            if (getSet(u) != getSet(v)) {
                unionSets(u, v);
                ostovWeight += edge.cost;
            }
        }

        return ostovWeight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();       // number of vertex
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            makeSet(i);

        int m = in.nextInt();       // number of edges
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
           edges[i] = new Edge(in.nextInt()-1, in.nextInt()-1, in.nextInt());
        }

        System.out.println(kruskal(edges));
    }
}