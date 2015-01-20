// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class DocumentSearch {

    public int nonIntersecting(String[] doc, String search) {
        StringBuilder sb = new StringBuilder();
        for (String str : doc) {
            sb.append(str);
        }

        int count = 0;
        int index = 0;
        while (index >= 0) {
            index = sb.indexOf(search);
            try {
                sb.delete(index, index+search.length());
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                // 
            }
        }

        return count;
    }

    public static void test(int exp, int res) {
        System.out.println("[EXP]:"+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {
        DocumentSearch obj = new DocumentSearch();
        test(1, obj.nonIntersecting(
                    new String[]{"ababababa"},
                    "ababa"));
        //The example from the problem statement.

        test(2, obj.nonIntersecting(
                    new String[]{"ababababa"},
                    "aba"));
        //There are multiple ways to find the string twice, but it doesn't matter how we do it.

        test(1, obj.nonIntersecting(
                    new String[]{"abcdefghijklmnop",
                        "qrstuvwxyz"},
                        "pqrs"));
        //Be sure to concatenate the document first.

        test(3, obj.nonIntersecting(
                    new String[]{"aaa", "aa", "a", "a"},
                    "aa"));
    }
}
