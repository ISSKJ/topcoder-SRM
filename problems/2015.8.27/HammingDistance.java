// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class HammingDistance {

    public int minDistance(String[] numbers) {
        int len = numbers[0].length();

        int min = 100;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int n = 0; n < len; n++) {
                    if (numbers[i].charAt(n) != numbers[j].charAt(n)) {
                        cnt++;
                    }
                }
                min = Math.min(cnt, min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        TestUtil.test(obj.minDistance(
                    new String[]{"11010", "01100"}), 3);
        // The example from the problem statement.

        TestUtil.test(obj.minDistance(
                    new String[]{"00", "01", "10", "11"}), 1);

        // A binary code that uses all possible codewords has minimum Hamming distance 1.

        TestUtil.test(obj.minDistance(
                    new String[]{"000", "011", "101", "110"}), 2);

        // Adding a "parity bit" to the binary numbers of example 1 increases the minimum 
        // Hamming distance to 2.

        TestUtil.test(obj.minDistance(
                    new String[]{"01100", "01100", "10011"}), 0);

        // Note that the input may contain identical numbers (Hamming distance 0).

        TestUtil.test(obj.minDistance(
                    new String[]{"00000000000000000000000000000000000000000000000000",
                        "11111111111111111111111111111111111111111111111111"}), 50);

        TestUtil.test(obj.minDistance(
                    new String[]{"000000", "000111", "111000", "111111"}), 3);
    }
}
