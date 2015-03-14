// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class ValueOfString {

    public int findValue(String s) {

        int len, res, tmp;

        len = s.length();
        res = 0;

        for (int i = 0; i < len; i++)  {
            tmp = (s.charAt(i) - 'a')+1;
            res += tmp * findOther(tmp, s);
        }
        return res;
    }

    private int findOther(int n, String s) {
        int len = s.length();
        int tmp;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            tmp = (s.charAt(i) - 'a')+1;
            if (tmp <= n) {
                cnt++;
            }
        }
        return cnt;
    }

}

