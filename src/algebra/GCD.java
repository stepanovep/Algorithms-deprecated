package algebra;


public class GCD {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a/gcd(a,b)) * b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(-10, -21));
        System.out.println(lcm(10, 15));
    }
}
