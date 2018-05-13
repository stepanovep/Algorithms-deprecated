package sorting;

import java.util.Arrays;
import java.util.Random;


public class QuickSort {

    static Random rnd = new Random();

    static void quickSort(int a[], int left, int right) {
        if (left >= right)
            return;

        int i = left;
        int j = right;
        int sep = a[left + rnd.nextInt(right - left + 1)];

        while (i <= j) {
            while (a[i] < sep)
                i++;
            while (a[j] > sep)
                j--;
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        quickSort(a, left, j);
        quickSort(a, i, right);
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int N = 2_000_000;
        int[] a = rnd.ints(N).toArray();
        int[] b = a.clone();


        long startTime = System.currentTimeMillis();
        Arrays.sort(b);
        System.out.println("javaSort sort time: " + (System.currentTimeMillis() - startTime) + "ms");


        startTime = System.currentTimeMillis();
        quickSort(a, 0, N-1);
        System.out.println("myQSort sort time: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("Equals?  " + Arrays.equals(a, b));
    }
}
