package geometry;


import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class SegmentsUnion {

    static int segmentsUnionLength (int[] left, int[] right) {
        int n = left.length;
        int l = 0;

        ArrayList<Pair<Integer, Boolean>> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(new Pair<>(left[i], false));
            x.add(new Pair<>(right[i], true));
        }

        Collections.sort(x, (o1, o2) -> {
            if (Objects.equals(o1.getKey(), o2.getKey())) {
                if (!o1.getValue())
                    return -1;
                else
                    return 1;
            }
            else
                return o1.getKey() - o2.getKey();
        });

        int c = 0;
        for (int i = 0; i < 2*n; i++) {
            if (c*i > 0) {
                l += x.get(i).getKey() - x.get(i-1).getKey();
            }
            if (x.get(i).getValue())
                c--;
            else
                c++;
        }

        return l;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = in.nextInt();
            right[i] = in.nextInt();
        }

        System.out.println(segmentsUnionLength(left, right));
    }

}
