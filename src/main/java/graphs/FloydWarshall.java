package graphs;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

    private static void floyd_warshall(int d[][]) {

        int n = d.length;
        final int INF = 1_000_000;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (d[i][j] == -1)
                    d[i][j] = INF;

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (d[i][k] < INF && d[k][j] < INF)
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = in.nextInt();
            }
        }

        floyd_warshall(d);

        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(d[i]));
    }
}
