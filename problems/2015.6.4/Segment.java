// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class Segment {

    public String intersection(int[] s1, int[] s2) {

        s1 = norm(s1);
        s2 = norm(s2);

        int x1, x2, y1, y2;

        x1 = Math.max(s1[0], s2[0]);
        y1 = Math.max(s1[1], s2[1]);
        x2 = Math.min(s1[2], s2[2]);
        y2 = Math.min(s1[3], s2[3]);

        if (x1 == x2 && y1 == y2) {
            return "POINT";
        }
        if (x1 <= x2 && y1 <= y2) {
            return "SEGMENT";
        }

        return "NO";
    }

    private int[] norm(int[] s) {
        return new int[]{
            Math.min(s[0], s[2]),
            Math.min(s[1], s[3]),
            Math.max(s[0], s[2]),
            Math.max(s[1], s[3])
        };
    }

    public static void main(String[] args) {
        Segment obj = new Segment();

        TestUtil.test(obj.intersection(
                    new int[]{0, 0, 0, 1},
                    new int[]{1, 0, 1, 1}), "NO");
        // The segments are parallel and there is no intersection.

        TestUtil.test(obj.intersection(
                    new int[]{0, 0, 0, 1},
                    new int[]{0, 1, 0, 2}), "POINT");
        // The segments are located on the same line and have only one common point (0,1).

        TestUtil.test(obj.intersection(
                    new int[]{0, -1, 0, 1},
                    new int[]{-1, 0, 1, 0}), "POINT");
        // The segments intersect at point (0,0).

        TestUtil.test(obj.intersection(
                    new int[]{0, 0, 2, 0},
                    new int[]{1, 0, 10, 0}), "SEGMENT");
        // The segments have a common line segment from (1,0) to (2,0).

        TestUtil.test(obj.intersection(
                    new int[]{5, 5, 5, 5},
                    new int[]{6, 6, 6, 6}), "NO");
        // These are two different points.

        TestUtil.test(obj.intersection(
                    new int[]{10, 0, -10, 0},
                    new int[]{5, 0, -5, 0}), "SEGMENT");
        // The segments have a common line segment from (-5,0) to (5,0).

    }
}
