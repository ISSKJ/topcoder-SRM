import java.util.*;

public class SquareScoresDiv2 {

    public int getScore(String s) {

        int cnt, res, len;

        len = s.length();
        cnt = res = 0;

        String cache = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            if (s.substring(i, i+1).equals(cache)) {
                cnt++;
            } else {
                cnt = 1;
            }

            res += cnt;
            cache = s.substring(i, i+1);
        }

        return res;
    }

    private static void test(int res, int exp) {
        System.out.println("[EXP]="+exp+" [RES]="+res);
    }

    public static void main(String[] args) {

        SquareScoresDiv2 obj = new SquareScoresDiv2();

        test(obj.getScore(
                    "aaaba"), 8);
        // The example explained above.

        test(obj.getScore(
                    "zzzxxzz"), 12);

        test(obj.getScore(
                    "abcdefghijklmnopqrstuvwxyz"), 26);
        test(obj.getScore(
                    "p"), 1);

        test(obj.getScore(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), 5050);
        // All substrings satisfy the condition.

    }
}
