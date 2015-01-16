// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class ResistorCombinations {

    public double closestValue(String[] reqS, double target) {
        double[] req = new double[reqS.length];
        for (int i = 0; i < reqS.length; i++) {
            req[i] = Double.parseDouble(reqS[i]);
        }

        ArrayList<Double> list = new ArrayList<Double>();

        double tmp = 0;
        for (int i = 0; i < req.length; i++) {
            boolean pal = false;
            for (int type = 0; type < 4; type++) {
                double total = 0;
                for (int j = 0; j < req.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (tmp == 0) {
                        tmp = req[i];
                    }
                    if (type == 0) {
                        total = calc(tmp, req[j], true, true);
                    }
                    else if (type == 1) {
                        if (pal) {
                            total = calc(tmp, req[j], false, true);
                            pal = false;
                        } else {
                            total = calc(tmp, req[j], true, false);
                            pal = true;
                        }
                    }
                    else if (type == 2) {
                        if (!pal) {
                            total = calc(tmp, req[j], false, true);
                            pal = true;
                        } else {
                            total = calc(tmp, req[j], true, false);
                            pal = false;
                        }
                    }
                    else if (type == 3) {
                        total = calc(tmp, req[j], false, false);
                    }


                    System.out.println("total:"+total+" tmp:"+tmp);

                    tmp = total;
                }
                System.out.println("---- max total:"+total+"-----");
                list.add(total);
                tmp = 0;
            }

            System.out.println("==");
        }

        list.add(target);

        Collections.sort(list);
        System.out.println("list:"+list);

        double low, high;
        low = high = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                try {
                    low = list.get(i-1);
                    high = list.get(i+1);
                    break;
                } catch (Exception e) {
                    // ignore
                }
            }
        }

        if (low == high) {
            return low;
        }

        return (target - low) > (high - target) ? high : low;

    }

    private double calc(double r1, double r2, boolean s1, boolean s2) {
        //System.out.println(r1+" "+r2+":"+s1+" "+s2);

        if (s1 && s2) {
            return r1+r2;
        }
        if (!s1 && !s2) {
            return 1.0 / ((1.0/r1) + (1.0/r2));
        }

        if (s1) {
            return r1+r2;
        } else {
            return 1.0 / ((1.0/r1) + (1.0/r2));
        }
    }

    private static void test(double res, double exp) {
        System.out.println("[EXP]:"+exp+"\n[RES]:"+res+"\n");
    }

    public static void main(String[] args) {

        ResistorCombinations obj = new ResistorCombinations();

        test(obj.closestValue(
                    new String[]{"2","3","5"}, 2.5), 
                2.5);
// The example from above.  The target value can be exactly reached 
// by adding the 2 and 3 ohm resistors in series to make another 5 ohm resistor, 
// and then adding that in parallel with the original 5 ohm resistor to get a 2.5 ohm resistor.

    test(obj.closestValue(
                new String[]{"2","3","5"}, 1),
            0.967741935483871);

// The closest value in this case comes from adding all the resistors in parallel: 
// 1/R=1/2+1/3+1/5, R=30/31.

    test(obj.closestValue(
                new String[]{"10.25","13.31","6.777","12.2"}, 10.5),
            10.510805181371511);

// In this case the best value comes from adding resistors 0 and 1 in series, 
// resistors 2 and 3 in series, and then adding both of those in parallel.

3)
    test(obj.closestValue(
new String[]{"10000","2000","300","40","5"}
20000

Returns: 12345.0

4)
{"125.10000","00270.9","000625.55","90.100000","0015.60000"}
153

Returns: 152.75975812465552
}
