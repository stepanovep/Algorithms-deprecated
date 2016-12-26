package sorting;

import java.util.Arrays;
import java.util.Random;


public class MergeSort {

    static Random rnd = new Random();
    static int[] b;

    private static void mergeSort(int[] a) {
        int n = a.length;
        b = new int[n];
        mergeSort(a, 0, n-1);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) >> 1;
        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);

        merge(a, left, mid, right);
    }

    static void merge(int[] a, int left, int mid, int right) {

        System.arraycopy(a, left, b, left, right + 1 - left);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (b[i] < b[j])
                a[k++] = b[i++];
            else
                a[k++] = b[j++];
        }

        while (i <= mid) {
            a[k++] = b[i++];
        }
    }

    public static void main(String[] args) {
        final int N = 10_000_000;

        int[] a = rnd.ints(N).toArray();
        int[] b = a.clone();

        long startTime = System.currentTimeMillis();
        mergeSort(a);
        System.out.println("MergeSort: " + (System.currentTimeMillis() - startTime) + "ms");


        startTime = System.currentTimeMillis();
        Arrays.sort(b);
        System.out.println("JavaSort: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("equals? " + Arrays.equals(a,b));
    }
}
