// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class CCipher {
    public String decode(String cipher, int shift) {

        StringBuilder res = new StringBuilder();

        int size = cipher.length();
        for (int i = 0; i < size; i++) {
            char ch = cipher.charAt(i);
            ch -= shift;
            if (ch < 'A') {
                ch += 'Z' - 'A' + 1;
            }
            res.append(ch);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        CCipher obj = new CCipher();
        TestUtil.test(obj.decode(
                    "VQREQFGT", 2), "TOPCODER");

        TestUtil.test(obj.decode(
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10), "QRSTUVWXYZABCDEFGHIJKLMNOP");

        TestUtil.test(obj.decode(
                    "TOPCODER", 0), "TOPCODER");

        TestUtil.test(obj.decode(
                    "ZWBGLZ", 25), "AXCHMA");

        TestUtil.test(obj.decode(
                    "DBNPCBQ", 1), "CAMOBAP");

        TestUtil.test(obj.decode(
                    "LIPPSASVPH", 4), "HELLOWORLD");
    }
}

