package sorting;

import java.util.Arrays;
import java.util.Random;


public class BubbleSort {

    static void bubbleSort(int a[]) {
        int n  = a.length;
        boolean isChanged;

        for (int i = 1; i < n; ++i) {
            isChanged = false;
            for (int j = 0; j < n-i; ++j) {
                if (a[j] > a[j+1]) {
                    isChanged = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if (!isChanged)
                break;
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int N = 10_000;
        int[] a = rnd.ints(N).toArray();
        int[] b = a.clone();


        long startTime = System.currentTimeMillis();
        Arrays.sort(b);
        System.out.println("javaSort sort time: " + (System.currentTimeMillis() - startTime) + "ms");


        startTime = System.currentTimeMillis();
        bubbleSort(a);
        System.out.println("bubble sort time: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("Equals?  " + Arrays.equals(a, b));
    }

}
