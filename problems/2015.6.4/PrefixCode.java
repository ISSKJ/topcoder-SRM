// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class PrefixCode {

    public String isOne(String[] words) {
        String res = "Yes";

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].indexOf(words[i]) == 0) {
                    return "No, "+i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PrefixCode obj = new PrefixCode();

        TestUtil.test(obj.isOne(
                    new String[]{"trivial"}), "Yes");
        // As there is only one word, no word can be the prefix of another, so this is a trivial example of a prefix code.

        TestUtil.test(obj.isOne(
                    new String[]{"10001", "011", "100", "001", "10"}), "No, 2");
        //  "100" (at index 2) and "10" (at index 4) are both a prefix of "10001" and "10" is also a prefix of "100", therefore it is no prefix code. "100" is the prefix with the lowest index.

        TestUtil.test(obj.isOne(
                    new String[]{"no", "nosy", "neighbors", "needed"}), "No, 0");

        TestUtil.test(obj.isOne(
                    new String[]{"1010", "11", "100", "0", "1011"}), "Yes");

        TestUtil.test(obj.isOne(
                    new String[]{"No", "not"}), "Yes");

    }
}

