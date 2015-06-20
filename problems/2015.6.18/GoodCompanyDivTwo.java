// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class GoodCompanyDivTwo {

    public int countGood(int[] superior, int[] workType) {

        int res = 0;
        for (int i = 0; i < superior.length; i++) {
            int[] tmp = new int[101];
            tmp[workType[i]]++;

            for (int j = 0; j < superior.length; j++) {
                if (i == j) continue;

                if (superior[j] == i) {
                    tmp[workType[j]]++;
                }
            }

            boolean diverse = true;
            for (int j = 0; j < 101; j++) {
                if (tmp[j] > 1) {
                    diverse = false;
                    break;
                }
            }

            if (diverse) res++;
        }
        return res;
    }


    public static void main(String[] args) {
        GoodCompanyDivTwo obj = new GoodCompanyDivTwo();

        TestUtil.test(obj.countGood(
                    new int[]{-1, 0},
                    new int[]{1, 2}), 2);
        // The department of employee 0 contains employees 0 and 1.
        // The department of employee 1 contains employee 1 only.
        // Both departments are diverse.

        TestUtil.test(obj.countGood(
                    new int[]{-1, 0},
                    new int[]{1, 1}), 1);
        //  The departments are the same as in Example 0.
        //  However, now the department of employee 0 is not diverse: it contains two employees who do the same type of work.
        //  Only the department of employee 1 is now diverse.

        TestUtil.test(obj.countGood(
                    new int[]{-1, 0, 1, 1},
                    new int[]{1, 4, 3, 2}), 4);

        // Note that in this test case the department of employee 0 contains only employees 0 and 1. Employees 2 and 3 do not belong into the department of employee 0.

        TestUtil.test(obj.countGood(
                    new int[]{-1, 0, 1, 0, 0},
                    new int[]{3, 3, 5, 2, 2}), 4);

        TestUtil.test(obj.countGood(
                    new int[]{-1, 0, 1, 1, 1, 0, 2, 5},
                    new int[]{1, 1, 2, 3, 4, 5, 3, 3}), 7);

        TestUtil.test(obj.countGood(
                    new int[]{-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4},
                    new int[]{4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8}), 27);
    }
}


