// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class RedAndGreen {

    public int minPaints(String row) {

        char[] original = row.toCharArray();
        char[] converted = convert(row);

        int count = 0;
        int subCount = 0;
        int secCount = 0;
        boolean allGreen = true;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != converted[i]) {
                count++;
            }
        }

        for (int i = 0; i < original.length; i++) {
            if (converted[i] == 'R') {
                subCount++;
            }
        }

        int pos = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == 'G') {
                pos = i;
                break;
            }
        }

        for (int i = original.length-1; i >= pos; i--) {
            if (converted[i] == 'R') {
                secCount++;
            }
        }
        System.out.println();
        System.out.println("ORIG:"+new String(original)+"\nCONV:"+new String(converted));
        System.out.println("COUNT:"+count+" subCount:"+subCount+" SecCount:"+secCount);
        return Math.min(Math.min(count, subCount), secCount);
    }

    private char[] convert(String str) {
        char[] tmp = str.toCharArray();
        Arrays.sort(tmp);

        StringBuilder s = new StringBuilder(new String(tmp));
        s.reverse();
        return s.toString().toCharArray();
    }

    public static void main(String[] args) {
        RedAndGreen obj = new RedAndGreen();

        TestUtil.test(obj.minPaints(
                    "RGRGR"), 2);
                 // "RRRGG"
        // Paint the squares in the marked positions in the picture below with the opposite color. There are other ways with 2 total paints.
        // RGRGR
        // |  |
        // RRRGG

        TestUtil.test(obj.minPaints(
                    "RRRGGGGG"), 0);
        // There is no need to paint anything.

        TestUtil.test(obj.minPaints(
                    "GGGGRRR"), 3);
                //  "RRRGGGG"
        // Paint all the red squares green.

        TestUtil.test(obj.minPaints(
                    "RGRGRGRGRGRGRGRGR"), 8);

        TestUtil.test(obj.minPaints(
                    "RRRGGGRGGGRGGRRRGGRRRGR"), 9);
        //          "RRRGGGRGGGRGGRRRGGRRRGR"), 9);

    }
}
