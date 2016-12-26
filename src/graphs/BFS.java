package graphs;

import java.util.*;

public class BFS {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static double[] dist;
    static int[] p;

    static void BFS(int s) {
        int n = graph.length;
        visited = new boolean[n];
        dist = new double[n];
        Arrays.fill(dist, 1e6);
        p = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        p[s] = -1;
        dist[s] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int to: graph[v]) {
                if (!visited[to]) {
                    visited[to] = true;
                    queue.add(to);
                    dist[to] = dist[v]+1;
                    p[to] = v;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        BFS(0);

        System.out.println(Arrays.toString(dist));
    }
}
