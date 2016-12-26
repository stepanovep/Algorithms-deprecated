package sorting;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;
import java.util.Random;

class RadixSort {

    private static void radixSort(int[] a) {
        int i, exp = 1;
        int n = a.length;
        int[] b = new int[n];

       int m = a[0];
       for (i = 1; i < n; i++)
           m = Integer.max(m, a[i]);

        while (m / exp > 0) {
            int[] bucket = new int[10];

            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;

            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];

            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];

            for (i = 0; i < n; i++)
                a[i] = b[i];

            exp *= 10;
        }
    }

    public static void main(String[] args) {

        final int N = 10_000_000;
        int[] a = new int[N];

        Random rnd = new Random();
        for (int i = 0; i < N; i++)
            a[i] = rnd.nextInt(1000);

        int[] b = a.clone();

        long startTime = System.currentTimeMillis();
        radixSort(a);
        System.out.println("RadixSort: " + (System.currentTimeMillis() - startTime) + "ms");


        startTime = System.currentTimeMillis();
        Arrays.sort(b);
        System.out.println("JavaSort: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("equals? " + Arrays.equals(a,b));
    }
}
