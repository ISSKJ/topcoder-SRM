// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class CultureShock {

    public String translate(String text) {
        /*
        String[] tmp = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            sb.append(tmp[i].equals("ZEE") ? "ZED" : tmp[i]);
            if (i < tmp.length-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
        */
        if (text.equals("ZEE")) {
            return "ZED";
        }
        return text.replaceAll("ZEE ", "ZED ").replaceAll(" ZEE", " ZED");
    }

    public static void main(String[] args) {

        CultureShock obj = new CultureShock();
        TestUtil.test(obj.translate(
                    "THE TWENTY SIXTH LETTER OF THE ALPHABET IS ZEE"),
                "THE TWENTY SIXTH LETTER OF THE ALPHABET IS ZED");
        // There is precisely one occurrence of "ZEE" in this line of text, so it should be replaced with "ZED".

        TestUtil.test(obj.translate(
                    "ZEE"), "ZED");

        TestUtil.test(obj.translate(
                    "SPELLING IN ENGLISH IS EZEE"), 
                "SPELLING IN ENGLISH IS EZEE");
        // The "ZEE" at the end of this line should not be altered since it is part of a larger word.

        TestUtil.test(obj.translate(
                    "ZEE ZEE ZED ZEDS ZEE ZEES"),
                "ZED ZED ZED ZEDS ZED ZEES");
    }
}

