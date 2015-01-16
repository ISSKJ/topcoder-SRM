// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class PatternOptimizer {

    public String optimize(String pattern) {

        String res = pattern.replaceAll("\\*.[\\?]\\*", "\\?\\*\\?");

        for (int i = 0 ; i < pattern.length(); i++) {
            res = res.replaceAll("\\?\\*", "\\*\\?");
            res = res.replaceAll("\\*\\*", "\\*");
        }


        return res;
    }


    private static void test(String exp, String res) {
        System.out.println(String.format("EXP: %s\nRES: %s\n", exp, res));
    }

    public static void main(String[] args) {
        PatternOptimizer obj = new PatternOptimizer();

        test("*??a", obj.optimize("*??*a"));
        test("*b*a", obj.optimize("*b**a"));
        test("cla??", obj.optimize("cla??"));
        test("*???", obj.optimize("*?*?*?*"));
        test("T*nd*?", obj.optimize("T**nd?*"));
    }
}
