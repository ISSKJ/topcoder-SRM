// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class MagicalGirlLevelOneDivTwo {

    public double theMinDistance(int d, int x, int y) {
        int rangeX, rangeY;
        x = Math.abs(x);
        y = Math.abs(y);

        if (x > d)
            rangeX = Math.abs(d-x);
        else {
            x = 0;
            rangeX = 0;
        }

        if (y > d)
            rangeY = Math.abs(y-d);
        else {
            y = 0;
            rangeY = 0;
        }

        return Math.sqrt(Math.pow(rangeX, 2) + Math.pow(rangeY, 2));

    }

    public static void main(String[] args) {
        MagicalGirlLevelOneDivTwo obj = new MagicalGirlLevelOneDivTwo();

        TestUtil.test(obj.theMinDistance(
                    5, 10, 10), 7.0710678118654755);
        // Moving to (5, 5) achieves the minimum distance. The distance is sqrt(5*5 + 5*5) = 7.0710678118654755.

        TestUtil.test(obj.theMinDistance(
                    5, 10, 3), 5.0);

        // Moving to (5, 0) achieves the minimum distance. The distance is sqrt(5*5 + 0*0) = 5.

        TestUtil.test(obj.theMinDistance(
                    5, -8, -6), 3.1622776601683795);

        TestUtil.test(obj.theMinDistance(
                    5, 3, 2), 0.0);
        // The evil witch is already inside of the square.

        TestUtil.test(obj.theMinDistance(
                    24, 24, -24), 0.0);

        TestUtil.test(obj.theMinDistance(
                    345, -471, 333), 126.0);
    }
}

