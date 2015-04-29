// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class Chessboard {

    public String changeNotation(String cell) {

        StringBuilder res = new StringBuilder();

        int n = getNumber(cell);
        if (n > 0) {
            int col = n % 8;
            res.append((char)('a'+n-1));
            int row = n / 8 + 1;
            res.append(row);
            return res.toString();
        } else {
            n = 0;
            int col = getNumber(""+cell.charAt(1));
            n += 8 * (col-1);
            n += cell.charAt(0) - 'a' + 1;
            return String.valueOf(n);
        }
    }

    private int getNumber(String cell) {
        try {
            return Integer.parseInt(cell);

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Chessboard obj = new Chessboard();

        TestUtil.test(obj.changeNotation(
                    "1"), "a1");
        TestUtil.test(obj.changeNotation(
                    "2"), "b1");

        TestUtil.test(obj.changeNotation(
                    "26"), "b4");

        TestUtil.test(obj.changeNotation(
                    "c1"), "3");

        TestUtil.test(obj.changeNotation(
                    "e4"), "29");

        TestUtil.test(obj.changeNotation(
                    "h8"), "64");
    }
}
