package string;

import java.util.Scanner;

public class ZFunction {

    private static int [] zFunction(String s) {
        int n = s.length();
        int z[] = new int[n];

        for (int i=1, l=0, r=0; i<n; ++i) {
            if (i <= r)
                z[i] = Math.min(r-i+1, z[i-l]);
            while (i+z[i] < n && s.charAt(z[i]) == s.charAt(i+z[i]))
                ++z[i];
            if (i+z[i]-1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        int [] z = zFunction(t + "#" + s);

        int l = t.length();
        for (int i = l+1; i < z.length; ++i) {
            if (z[i] == l) {
                System.out.print(i-l-1);
                System.out.print(' ');
            }
        }
    }
}