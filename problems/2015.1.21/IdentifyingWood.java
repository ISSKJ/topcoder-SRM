import java.util.*;


public class IdentifyingWood {

    private static final String YEP = "Yep, it's wood.";
    private static final String NOPE = "Nope.";

    public String check(String s, String t) {

        int size = t.length();
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (index <= s.indexOf(t.charAt(i))) {
                index = s.indexOf(t.charAt(i));
            } else {
                return NOPE;
            }
        }
        return YEP;
    }

    private static void test(String res, String exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }

    public static void main(String[] args) {

        IdentifyingWood obj = new IdentifyingWood();
        test(obj.check(
                    "absdefgh",
                    "asdf"), "Yep, it's wood.");

        test(obj.check(
                    "oxoxoxox",
                    "ooxxoo"), "Nope.");

        test(obj.check(
                    "oxoxoxox",
                    "xxx"), "Yep, it's wood.");

        test(obj.check(
                    "qwerty",
                    "qwerty"), "Yep, it's wood.");

        test(obj.check(
                    "string",
                    "longstring"), "Nope.");
    }
}

