import java.util.*;

public class ForgetfulAddition {

    public int minNumber(String expr) {

        ArrayList<Integer> probs = new ArrayList<Integer>();

        int size = expr.length();
        for (int i = 1; i < size; i++) {
            StringBuilder sb = new StringBuilder(expr);
            sb.insert(i, '+');
            probs.add(eval(sb.toString()));
        }

        Collections.sort(probs);

        return probs.get(0);
    }

    private int eval(String str) {
        String[] op = str.split("\\+");
        int res = 0;
        for (String s : op) {
            res += Integer.parseInt(s);
        }
        return res;
    }

    private static void test(int res, int exp) {
        System.out.println("[EXP]="+exp+"\n[RES]="+res+"\n");
    }

    public static void main(String[] args) {
        ForgetfulAddition obj = new ForgetfulAddition();

        test(obj.minNumber("22"), 4);
        // The only possible expression Alice could have typed is "2+2". Thus, Bob knows this evaluates to 4.

        test(obj.minNumber("123"), 15);
        // The expression Alice has typed could have been "1+23" or "12+3". Of these two, the second is smaller, thus Bob will get the answer 15.

        test(obj.minNumber("1289"), 101);
        // This is the example from the problem statement.

        test(obj.minNumber("31415926"), 9067);

        test(obj.minNumber("98765"), 863);

    }
}

