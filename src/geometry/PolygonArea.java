package geometry;


import java.util.Scanner;

public class PolygonArea {

    static double polygonArea (int[] x, int[] y) {
        double s = 0;
        int n = x.length;

        int[] X = new int[n+1];
        int[] Y = new int[n+1];
        for (int i = 0; i < n; i++) {
            X[i] = x[i];
            Y[i] = y[i];
        }
        X[n] = x[0]; Y[n] = y[0];

        for (int i = 0; i < n; i++) {
            s += (X[i+1]+X[i]) * (Y[i+1]-Y[i]);
        }

        return Math.abs(s) / 2.0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        System.out.println(polygonArea(x, y));
    }

}

