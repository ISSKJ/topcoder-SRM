// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import java.math.*;

public class StrongPrimePower {

    public int[] baseAndExponent(String n) {


        ArrayList<Integer> list = new ArrayList<Integer>();
        double bi = Double.parseDouble(n);

        double tmp = bi;
        for (int i = 2; i < bi; i++) {
            boolean prime = true;

            for (int j = 3; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            boolean isEnd = false;
            if (prime) {
                for (;;) {
                    if (tmp % i == 0) {
                        list.add(i);
                        tmp /= (double)i;
                        if (tmp < i) {
                            isEnd = true;
                            break;
                        }

                        int tmpX = i;
                        for (int X : list) {
                            if (tmpX != X) {
                                list.clear();
                                break;
                            }
                            tmpX = X;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (isEnd) {
                break;
            }
        }

        if (list.size() == 0) {
            return new int[]{};
        }

        int count = 0;
        int i = list.get(0);
        for (int x : list) {
            if (x != i) {
                return new int[]{};
            }
            i = x;
            count++;
        }


        return new int[]{i, count};
    }
    
    public static void test(int[] res, int[] exp) {
        System.out.println("[EXP]:");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]+" ");
        }
        System.out.println();
        System.out.println("[RES]:");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StrongPrimePower obj = new StrongPrimePower();

        test(obj.baseAndExponent
                ("27"),
                new int[]{3, 3});
        // 27 = 33. This is a strong prime power.

        test(obj.baseAndExponent
                ("10"),
                new int[]{ });
        // 10 = 2 * 5. This is not a strong prime power.

        test(obj.baseAndExponent
                ("7"),
                new int[]{ });
        // A prime number is not a strong prime power.

        test(obj.baseAndExponent
                ("1296"), 
                new int[]{ });

        test(obj.baseAndExponent
                ("576460752303423488"),
                new int[]{2, 59});

        //test(obj.baseAndExponent
        //        ("999999874000003969"),
        //        new int[]{999999937, 2});
    }
}
