package graphs;

import java.util.Arrays;
import java.util.Scanner;

public class FordBellman {

    private static int[] dist;
    private static final int INF = 1_000_000;

    private static int[] ford_bellman(Edge[] edges, int s) {
        Arrays.fill(dist, INF);
        dist[s] = 0;
        while(true) {
            boolean changed = false;
            for (Edge edge : edges) {
                if (dist[edge.from] < INF) {
                    if (dist[edge.to] > dist[edge.from] + edge.cost) {
                        dist[edge.to] = dist[edge.from] + edge.cost;
                        changed = true;
                    }
                }
            }
            if (!changed)
                break;
        }

        return dist;
    }

    private static class Edge {
        int from;
        int to;
        int cost;

        Edge(int u, int v, int c) {
            from = u;
            to = v;
            cost = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dist = new int[n];

        int m = in.nextInt();
        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(in.nextInt()-1, in.nextInt()-1, in.nextInt());
        }

        for (int d: ford_bellman(edges, 0))
            System.out.print(d + " ");
    }
}
