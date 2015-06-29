// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class ClassScores {

    public int[] findMode(int[] scores) {

        int[] tmp = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            for (int j = i+1; j < scores.length; j++) {
                if (scores[i] == scores[j]) {
                    tmp[i]++;
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (max < tmp[i]) {
                index = i;
                max = tmp[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < tmp.length; i++) {
            if (max == tmp[i]) {
                list.add(scores[i]);
            }
        }

        Collections.sort(list);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ClassScores obj = new ClassScores();
        TestUtil.test(obj.findMode(
                    new int[]{65, 70, 88, 70}),
                new int[]{70});
        // The first example from the problem statement.

        TestUtil.test(obj.findMode(
                    new int[]{88, 70, 65, 70, 88}),
                new int[]{70, 88 });

        // The second example from the problem statement.

        TestUtil.test(obj.findMode(
                    new int[]{92, 56, 14, 73, 22, 38, 93, 45, 55}), 
                new int[]{14, 22, 38, 45, 55, 56, 73, 92, 93 });

        // With no duplicates, all of the elements are the most frequent (appearing once each).
    }
}
