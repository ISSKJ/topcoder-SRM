// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class SimpleWordGame {

    public int points(String[] player, String[] dictionary) {
        ArrayList<String> p1 = new ArrayList<String>();
        ArrayList<String> p2 = new ArrayList<String>();

        for (String s : player) {
            if (!p1.contains(s)) {
                p1.add(s);
            }
        }

        for (String s : dictionary) {
            if (!p2.contains(s)) {
                p2.add(s);
            }
        }

        int res = 0;
        for (String s1 : p1) {
            if (p2.contains(s1)) {
                res += s1.length()*s1.length();
            }

        }

        return res;
    }

    public static void main(String[] args) {
        SimpleWordGame obj = new SimpleWordGame();
        TestUtil.test(obj.points(
                    new String[]{ "apple", "orange", "strawberry" },
                    new String[]{ "strawberry", "orange", "grapefruit", "watermelon" }), 136);
        // The player has correctly remembered two words from the dictionary: "orange" (worth 6*6 = 36 points) and "strawberry" (worth 10*10 = 100 points). That gives a total score of 136 points.

        TestUtil.test(obj.points(
                    new String[]{ "apple" },
                    new String[]{ "strawberry", "orange", "grapefruit", "watermelon" }), 0);
        // The player has remembered just "apple" and it's not in the dictionary, so the score is 0.

        TestUtil.test(obj.points(
                    new String[]{ "orange", "orange" },
                    new String[]{ "strawberry", "orange", "grapefruit", "watermelon" }), 36);
        // The "orange" occurs twice in player, but should be counted just once towards the score.
        //
        TestUtil.test(obj.points(
                    new String[]{ "lidi", "o", "lidi", "gnbewjzb", "kten", "ebnelff", "gptsvqx", "rkauxq", "rkauxq", "kfkcdn"},
                    new String[]{ "nava", "wk", "kfkcdn", "lidi", "gptsvqx", "ebnelff", "hgsppdezet", "ulf", "rkauxq", "wcicx"}), 186);


    }
}

