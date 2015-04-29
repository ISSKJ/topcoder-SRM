// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class Straights {

    public int howMany(int[] hand, int k) {

        int res = 0;
        for (int i = 0; i <= hand.length - k; i++) {
            if (hand[i] == 0) {
                continue;
            }
            int n = 1;
            for (int j = 0; j < k; j++) {
                n *= hand[i+j];
            }
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        Straights obj = new Straights();
        TestUtil.test(obj.howMany(
                    new int[]{0,3,1,2,0,0,0,0,0,0,0,0,0}, 2), 5);
        // The example given.

        TestUtil.test(obj.howMany(
                    new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1}, 5), 9);
        // Say hand[0] references Aces. There are 9 ways to make a straight of length 5: Ace-Five up to Nine-King.

        TestUtil.test(obj.howMany(
                    new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4}, 13), 67108864);

        TestUtil.test(obj.howMany(
                    new int[]{4,0,4,0,4,0,4,0,4,0,4,0,4}, 2), 0);
        // Straights do not wrap around; we have no straights here.

        TestUtil.test(obj.howMany(
                    new int[]{1,2,3,4,1,2,3,4,1,2,3,4,1}, 1), 31);
    }
}
