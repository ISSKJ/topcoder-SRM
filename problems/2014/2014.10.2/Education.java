// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class Education {

    // min: A = 90 B = 80 C = 70 D = 60
    public int minimize(String desire, int[] tests) {

        double sum = 0;
        for (int i = 0; i < tests.length; i++) {
            sum += tests[i];
        }

        int min;
        if ("A".equals(desire)) {
            min = 90;
        } else if ("B".equals(desire)) {
            min = 80;
        } else if ("C".equals(desire)) {
            min = 70;
        } else if ("D".equals(desire)) {
            min = 60;
        } else {
            return -1;
        }

        double x = (tests.length+1) * min - sum;
        if (x > 100)  {
            return -1;
        } else if (x < 0){
            return 0;
        } else {
            return (int)x;
        }
    }

    private static void test(int exp, int res) {
        System.out.println("[EXP]:"+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {

        Education obj = new Education();

        test(-1, obj.minimize(
                    "A", 
                    new int[]{0,70}));
        test(0, obj.minimize(
                    "D",
                    new int[]{100,100,100,100,100,100}));
        test(87, obj.minimize(
                    "B",
                    new int[]{80,80,80,73}));

        test(88, obj.minimize(
                    "B",
                    new int[]{80,80,80,73,79}));

        test(100, obj.minimize(
                    "A",
                    new int[]{80}));
    }

}
