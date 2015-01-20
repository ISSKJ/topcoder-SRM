// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class Bits {

    public int minBits(int n) {

        int cnt = 1;
        for (int i = 1; ; i++) {
            if (Math.pow(2, i) <= (double)n) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
