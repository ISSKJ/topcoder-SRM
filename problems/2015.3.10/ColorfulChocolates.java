// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class ColorfulChocolates {

    public int maximumSpread(String choco, int maxSwaps) {

        int len = choco.length();

        for (int i = 0; i < maxSwaps; i++) {

            for (int j = 0; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    choco.charAt(j);
                }
            }

        }
    }

    public static void test(int exp, int res) {
    }

    public static void main(String[] args) {
        ColorfulChocolates obj = new ColorfulChocolates();

        test(obj.maximumSpread(
                    "ABCDCBC", 1), 2);
        // One optimal solution is to swap chocolates at positions 2 and 3, obtaining the row "ABDCCBC", which has spread 2.

        test(obj.maximumSpread(
                    "ABCDCBC", 2), 3);
        // The only optimal solution is to produce the row "ABDCCCB".

        test(obj.maximumSpread(
                    "ABBABABBA", 3), 4);
        // The row "ABBBBAABA" can be produced with 3 swaps.

        test(obj.maximumSpread(
                    "ABBABABBA", 4), 5);
        // An optimal solution is to produce the row "AABBBBBAA".

        test(obj.maximumSpread(
                    "QASOKZNHWNFODOQNHGQKGLIHTPJUVGKLHFZTGPDCEKSJYIWFOO", 77), 5);
    }
}
