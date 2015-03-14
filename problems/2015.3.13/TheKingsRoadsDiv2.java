import java.util.*;
import my.util.*;

public class TheKingsRoadsDiv2 {

    public String getAnswer(int h, int[] a, int[] b) {

        int len = a.length;

        ArrayList<Integer> visited = new ArrayList<Integer>();

        visited.add(a[0]);
        visited.add(b[0]);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (visited.contains(a[j]) && visited.contains(b[j])) {
                    continue;
                }
                if (visited.contains(a[j])) {
                    visited.add(b[j]);
                }
                if (visited.contains(b[j])) {
                    visited.add(a[j]);
                }
            }
        }

        for (int i = 1; i <= len; i++) {
            if (!visited.contains(i)) {
                return "Incorrect";
            }
        }


        return "Correct";
    }


    public static void main(String[] args) {
        TheKingsRoadsDiv2 obj = new TheKingsRoadsDiv2();
        TestUtil.test(obj.getAnswer(
                    3,
                    new int[]{1, 2, 3, 7, 1, 5, 4},
                    new int[]{6, 7, 4, 3, 3, 1, 7}), "Correct");
        // City 3 was built during the first year, cities 1 and 7 during the second year, and the other four cities during the third year. Then the King added the road 3-4.

        TestUtil.test(obj.getAnswer(
                    2,
                    new int[]{1, 2, 3},
                    new int[]{2, 1, 3}), "Incorrect");

        TestUtil.test(obj.getAnswer(
                    3,
                    new int[]{7, 1, 1, 2, 2, 3, 1},
                    new int[]{7, 1, 7, 4, 5, 2, 6}), "Incorrect");

        TestUtil.test(obj.getAnswer(
                    2,
                    new int[]{1, 3, 3},
                    new int[]{2, 1, 2}), "Correct");

        TestUtil.test(obj.getAnswer(
                    3,
                    new int[]{6, 5, 3, 3, 5, 5, 6},
                    new int[]{1, 5, 5, 6, 4, 7, 2}), "Correct");
        // Here the road added by the King is obviously the self-loop from city 5 to itself.
    }
}
