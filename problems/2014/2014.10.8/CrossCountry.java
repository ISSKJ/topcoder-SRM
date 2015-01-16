// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class CrossCountry {

    private static final int MAX_ALPHABET = 26;
    private static final int INDEX_A = 65;

    public String scoreMeet(int num, String order) {

        int cnt, ch, size;
        int[] score, members, tmp;

        size = order.length();
        score = new int[MAX_ALPHABET];
        members = new int[MAX_ALPHABET];
        tmp = new int[MAX_ALPHABET];

        for (int i = 0; i < size; i++) {
            ch = order.charAt(i);
            if (members[(int)ch-INDEX_A] < 5) {
                score[(int)ch-INDEX_A] += i+1;
                members[(int)ch-INDEX_A]++;
            }
        }

        for (int i = 0; i < score.length; i++) {
            if (members[i] < 5) {
                members[i] = 0;
                score[i] = 0;
            }
        }

        System.arraycopy(score, 0, tmp, 0, score.length);
        Arrays.sort(tmp);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < score.length; i++) {
            int key = tmp[i];
            for (int j = 0; j < score.length; j++) {
                if (score[j] == key && key != 0) {
                    sb.append((char)(j+INDEX_A));
                    score[j] = 0;
                    break;
                }
            }
        }


        return sb.toString();
    }

    public static void test(String res, String exp) {
        System.out.println("[EXP]="+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {
        CrossCountry obj = new CrossCountry();

        test(obj.scoreMeet
                (2,"AABBABBABBA"), "AB");
        // The example from above.

        test(obj.scoreMeet
                (3 ,"CCCBBBBBAAACC"), "BC");
        // In this case team A does not qualify because only 3 of its runners finish.  
        // Team B beats team C with a score of 30-31.  Remember not to remove team A's runners, 
        // doing this would have team C win over team B with a score of 25-30.

        test(obj.scoreMeet
                (4, "ABDCBADBDCCDBCDBCAAAC"), "BDCA");

        test(obj.scoreMeet
                (10, "BDHCEAJBIDBCCHGCBDJEBAAHEGAGGADHGIECJEHAEBDADJCDHG"), "BCDAHEG");

        test(obj.scoreMeet
                (3, "BABCAABABAB"), "AB");
    }
}
