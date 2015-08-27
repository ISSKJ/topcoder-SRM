// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class Taxi {

    public double maxDis(int maxX, int maxY, int taxiDis) {

        double max, min, y;
        max = Math.max(maxX, maxY);
        min = Math.min(maxX, maxY);
        y = taxiDis - max;

        if (y < 0) {
            return taxiDis;
        }
        if (y > min) {
            return -1;
        }
        return Math.sqrt(y*y+max*max);
    }

    public static void main(String[] args) {

        Taxi obj = new Taxi();

        TestUtil.test(obj.maxDis(
                    10, 3, 3), 3.0);
        // The two points could lie in a straight line parallel to one of the axes. Then the straight-line distance would be the same as the taxicab distance.

        TestUtil.test(obj.maxDis(
                    10, 3, 24), -1.0);
        // No two points with 0<=x<=10, 0<=y<=3, have a taxicab distance between them that is as big as 24.

        TestUtil.test(obj.maxDis(
                    7, 10, 13), 10.44030650891055);
        // (5,0) and (2,10) are two points in this region whose taxicab distance is |2-5| + |10-0| = 13 and whose straight-line distance is sqrt(3*3 + 10*10) = sqrt(109).

        TestUtil.test(obj.maxDis(
                    4, 4, 7), 5.0);

        TestUtil.test(obj.maxDis(
                    976421, 976421, 1000000), 976705.6560100387);

    }
}

