// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class PointErasingTwo {

    public int getMaximum(int[] y) {

        int x1, y1, x2, y2, count;
        int max = 0;
        for (int i = 0 ; i < y.length; i++) {
            x1 = i;
            y1 = y[i];
            for (int j = i+1; j < y.length; j++) {
                x2 = j;
                y2 = y[j];
                //System.out.println(
                //        String.format("(%d, %d), (%d, %d)", x1, y1, x2, y2));
                count = 0;
                for (int k = i; k < j; k++) {
                    if (y1 < y2) {
                        // up side
                        if (y[k] > y1 && y[k] < y2) {
                            count++;
                        }
                    } else {
                        // down side
                        if (y[k] < y1 && y[k] > y2) {
                            count++;
                        }
                    }
                }
                //System.out.println("max:"+max+" count:"+count);
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        PointErasingTwo obj = new PointErasingTwo();

        TestUtil.test(obj.getMaximum(
                    new int[]{ 1, 2, 1, 1, 0, 4, 3 }), 2);
        // If Krolik chooses A = (1, 2) and B = (4, 0), Krolik can erase two points: (2, 1) and (3, 1). 

        TestUtil.test(obj.getMaximum(
                    new int[]{ 0, 1 }), 0);

        TestUtil.test(obj.getMaximum(
                    new int[]{ 0, 1, 2, 3, 4 }), 3);

        TestUtil.test(obj.getMaximum(
                    new int[]{ 10, 19, 10, 19 }), 0);

        TestUtil.test(obj.getMaximum(
                    new int[]{ 0, 23, 49, 50, 32, 0, 18, 50, 0, 28, 50, 27, 49, 0 }), 5);
    }
}
