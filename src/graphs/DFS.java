package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS {

    private static int cc[];            // component number for each vertex
    private static int current_c = 0;

    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    private static void explore(int v) {
        visited[v] = true;
        cc[v] = current_c;
        for (int to: graph[v]) {
            if (!visited[to])
                explore(to);
        }
    }

    private static void DFS() {
        Arrays.fill(visited, false);
        int n = graph.length;
        cc = new int[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                explore(v);
                current_c++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        final int n = 4;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        visited = new boolean[n];


        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            graph[from].add(to);
        }

        DFS();

        System.out.println(Arrays.toString(cc));
    }
}
