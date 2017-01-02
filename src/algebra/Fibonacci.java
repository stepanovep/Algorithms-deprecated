package algebra;


public class Fibonacci {

    /**
     * @param n
     * @return - return n-th Fibonacci number
     * Note: 0-indexing
     * 1, 1, 2, 3, 5, 8, 13, 21 ...
     */

    static long dumbFibonacci(int n) {
        if (n <= 1)
            return 1;
        return dumbFibonacci(n-1) + dumbFibonacci(n-2);
    }

    static long fairFibonacci(int n) {
        if (n <= 1)
            return 1;

        long a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            long c = a+b;
            a = b;
            b = c;
        }

        return b;
    }

    static final FiboMatrix fiboMatrix0 = new FiboMatrix();

    static class FiboMatrix {
        long a11, a12, a21, a22;
        FiboMatrix() {
            a11 = 1;
            a12 = a21 = 1;
            a22 = 0;
        }

        @Override
        public String toString() {
            return a11 + " " + a12 + "\n" +
                   a21 + " " + a22;
        }
    }

    static FiboMatrix binPowMatrix(FiboMatrix fb, int n) {
        if (n == 1)
            return fiboMatrix0;
        if (n % 2 == 0) {
            FiboMatrix tmp = binPowMatrix(fb, n/2);
            return multFiboMatrices(tmp, tmp);
        } else {
            return multFiboMatrices(binPowMatrix(fb, n-1), fiboMatrix0);
        }
    }

    static FiboMatrix multFiboMatrices(FiboMatrix fb1, FiboMatrix fb2) {
        FiboMatrix fb = new FiboMatrix();
        fb.a11 = fb1.a11*fb2.a11 + fb1.a12*fb2.a21;
        fb.a12 = fb1.a11*fb2.a12 + fb1.a12*fb2.a22;
        fb.a21 = fb1.a21*fb2.a11 + fb1.a22*fb2.a21;
        fb.a22 = fb1.a21*fb2.a12 + fb1.a22*fb2.a22;
        return fb;
    }

    static long fastFibonacci(int n) {
        return binPowMatrix(fiboMatrix0, n).a11;
    }

    public static void main(String[] args) {

        int n = 100_000_000;
        long startTime;

        /*startTime = System.currentTimeMillis();
        System.out.println(dumbFibonacci(n));
        System.out.println("recursive: " + (System.currentTimeMillis() - startTime) + "ms\n");
        */

        startTime = System.currentTimeMillis();
        System.out.println(fairFibonacci(n));
        System.out.println("dynamic: " + (System.currentTimeMillis() - startTime) + "ms\n");

        startTime = System.currentTimeMillis();
        System.out.println(fastFibonacci(n));
        System.out.println("fast: " + (System.currentTimeMillis()-startTime) + "ms");
    }

}
