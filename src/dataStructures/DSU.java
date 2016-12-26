package dataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class DSU {

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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        parent = new int[n];
        rank = new int[n];

        for (int v = 0; v < n; v++)
            makeSet(v);
        System.out.println(Arrays.toString(parent));

        unionSets(0, 1);
        unionSets(2, 3);

        System.out.println(Arrays.toString(parent));

        unionSets(0, 3);
        System.out.println(Arrays.toString(parent));
        System.out.println(getSet(3));
    }
}
