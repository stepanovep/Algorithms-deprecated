package string;

import java.util.Scanner;

public class PrefixFunction {

    private static int [] prefixFunction(String s) {
        int n = s.length();
        int [] pi = new int[n];

        for (int i=1; i < n; ++i) {
            int j = pi[i-1];
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j-1];
            if (s.charAt(i) == s.charAt(j)) ++j;
            pi[i] = j;
        }
        return pi;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        int [] pi = prefixFunction(t + "#" + s);

        int l = t.length();
        for (int i = l+1; i < pi.length; ++i) {
            if (pi[i] == l) {
                System.out.print(i-2*l);
                System.out.print(' ');
            }
        }
    }
}