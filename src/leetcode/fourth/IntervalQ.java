package leetcode.fourth;

import java.util.ArrayList;
import java.util.List;

public class IntervalQ {

    static class Interval {
        int start,end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {


            /**
             * A.....B
             *          ..  A......B
             */

            if (A[i].end < B[j].start) {
                i++;
            }
            /**
             *              A.........B
             * A.......B ..
             */
            else if (A[i].start > B[j].end) {
                j++;
            }

            /**
             * A......B
             *      A....B  =>   A....B
             *
             *
             *      A....B
             *   A.....B
             *
             *   A....B
             *        B....A
             */

            else {
                list.add(intersect(A[i], B[j]));
                if (A[i].end < B[j].end) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int n = list.size();
        Interval[] result = new Interval[n];
        for (int k = 0; k < n; k++) {
            result[k] = list.get(k);
        }
        return result;
    }
    private Interval intersect(Interval a, Interval b) {
        return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
    }
}
