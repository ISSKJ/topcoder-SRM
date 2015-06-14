// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class InterestingNumber {

    public String isInteresting(String x) {

        char[] str = x.toCharArray();

        int size = x.length();
        for (int i = 0; i < size; i++) {
            char start = str[i];
            int number = -1;
            try {
                number = Integer.parseInt(""+start);
            } catch (Exception e) {
                continue;
            }

            if (!checkSafe(str, i + number + 1, start) 
                    && !checkSafe(str, i - number - 1, start)) {
                return "Not interesting";
            }

            if (checkSafe(str, i + number + 1, start)) {
                str[i] = 'A';
                str[i + number + 1] = 'A';
            }
            if (checkSafe(str, i - number - 1, start)) {
                str[i] = 'A';
                str[i - number - 1] = 'A';
            }
        }

        return "Interesting";
    }

    private boolean checkSafe(char[] str, int index, char ch) {
        if (str.length <= index || index < 0) {
            return false;
        }
        return str[index] == ch;
    }

    public static void main(String[] args) {
        InterestingNumber obj = new InterestingNumber();
        TestUtil.test(obj.isInteresting(
                    "2002"), "Interesting");
        // There are 0 digits between the two 0s, and 2 digits between the two 2s, so this is an interesting number.

        TestUtil.test(obj.isInteresting(
                    "1001"), "Not interesting");
        // There should be 1 digit between the two 1s, but there are 2 digits between them. Hence, this number is not interesting.

        TestUtil.test(obj.isInteresting(
                    "41312432"), "Interesting");
        // This is the number in the statement.

        TestUtil.test(obj.isInteresting(
                    "611"), "Not interesting");
        // There is only one digit 6 in this number, so it's not interesting.

        TestUtil.test(obj.isInteresting(
                    "64200246"), "Interesting");

        TestUtil.test(obj.isInteresting(
                    "20020000"), "Not interesting");

        // This number contains the digit 1 three times.
    }
}
