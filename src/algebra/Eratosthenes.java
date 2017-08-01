package algebra;


import java.util.Arrays;

public class Eratosthenes {

    private static boolean primes[];

    private static void eratosthenes(int n) {

        primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i <= n; ++i) {
            if (primes[i]) {
                if (i * i <= n)
                    for (int j = i * i; j <= n; j += i)
                        primes[j] = false;
            }
        }

    }


    public static void main(String[] args) {

        int N = 1000;
        eratosthenes(N);
        for (int i = 1; i <= N; i++) {
            if (primes[i])
                System.out.print(i + " ");
        }

    }
}
