package dataStructures;

import static java.lang.Math.*;

public class SegmentTree {

    static final int invariant = 0;
    //static final int invariant = Integer.MAX_VALUE;
    //static final int invariant = Integer.MIN_VALUE;

    private final int n;
    private int[] t;

    private SegmentTree(int n) {
        this.n = (int) pow(2, ceil(log(n) / log(2)));  // floor to closest 2^k that >= n
        this.t = new int[2 * this.n];
    }

    private int queryFunc(int a, int b) {
        return a + b;
        //return min(a, b);
        //return max(a, b);
    }


    private void buildSegmentTree(int[] a) {
        buildSegmentTree(a, 0, 0, n - 1);
    }

    private void buildSegmentTree(int[] a, int v, int left, int right) {

        if (left == right) {
            if (left >= a.length)
                t[v] = invariant;
            else
                t[v] = a[left];
        } else {
            int mid = (left + right) >> 1;
            int child_id = v << 1;
            buildSegmentTree(a, child_id + 1, left, mid);
            buildSegmentTree(a, child_id + 2, mid + 1, right);
            t[v] = queryFunc(t[child_id + 1], t[child_id + 2]);
        }
    }

    /**
     * query method - return the query value over given segment [left; right]
     * @param left - inclusive
     * @param right - inclusive
     */
    private int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int v, int tLeft, int tRight, int l, int r) {
        if (l > r)
            return invariant;
        if (l == tLeft && r == tRight)
            return t[v];

        int tMid = (tLeft + tRight) >> 1;
        int child = v << 1;
        return queryFunc(
                query(child + 1, tLeft, tMid, l, min(r, tMid)),
                query(child + 2, tMid + 1, tRight, max(l, tMid + 1), r));
    }

    private void update(int pos, int new_val) {
        update(0, 0, n - 1, pos, new_val);
    }

    private void update(int v, int tLeft, int tRight, int pos, int new_val) {
        if (tLeft == tRight)
            t[v] = new_val;
        else {
            int tMid = (tLeft + tRight) >> 1;
            int child = v << 1;
            if (pos <= tMid)
                update(child + 1, tLeft, tMid, pos, new_val);
            else
                update(child + 2, tMid + 1, tRight, pos, new_val);

            t[v] = queryFunc(t[child + 1], t[child + 2]);
        }
    }


    public static void main(String[] args) {

        int n = 10;
        int [] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i+1;

        SegmentTree st = new SegmentTree(n);
        st.buildSegmentTree(a);

        System.out.println(st.query(0, 1));

        st.update(6, 4);
        System.out.println(st.query(5, 9));
        System.out.println(st.query(0, 2));
    }
}