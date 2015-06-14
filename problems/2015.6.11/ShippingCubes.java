// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class ShippingCubes {

    /*
    private int[] prime = {
        2, 3, 5, 7, 11, 13, 17, 19, 23,
        29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 
        71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
        113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 
        173, 179, 181, 191, 193, 197, 199
    };

    */
    public int minimalCost(int N) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {

            if (N % i == 0) {

                int second = N / i;
                for (int inner = 1; inner <= N; inner++) {
                    if (second % inner == 0) {
                        int third = second / inner;
                        if (i + inner + third < min) {
                            min = i + inner + third;
                        }
                    }
                }
            }
        }
        return min;

        /*
        ArrayList<Integer> parts = new ArrayList<Integer>();

        if (N == 1) {
            return 3;
        }

        int i = 45;
        int sum = N;
        while (sum > 1) {
            if (sum % prime[i] == 0) {
                //System.out.println("sum:"+sum);
                sum /= prime[i];
                parts.add(prime[i]);
            } else {
                i--;
            }
        }
        System.out.println(parts);

        if (parts.size() <= 3) {
            return get(parts, 0) + get(parts, 1) + get(parts, 2);
        } else {
            return get(parts, 0) + get(parts, 1) + other(parts, 2);
        }
        */
    }

    private int get(List<Integer> list, int i) {
        try {
            return list.get(i);
        } catch (Exception e) {
        }
        return 1;
    }

    private int other(List<Integer> list, int i) {
        int res = 1;
        for (int n = i; n < list.size(); n++) {
            res *= list.get(i);
        }
        return res;
    }



    public static void main(String[] args) {
        ShippingCubes obj = new ShippingCubes();

        TestUtil.test(obj.minimalCost(1), 3);
        // The only way is to use a box with dimensions 1 x 1 x 1.

        TestUtil.test(obj.minimalCost(6), 6);
        // This time one optimal solution is to send a box with dimensions 1 x 2 x 3. The cost of sending this box is 1+2+3 = 6. Any other option is at least as expensive as this one. For example, sending a box with dimensions 6 x 1 x 1 has the cost 6+1+1 = 8.

        TestUtil.test(obj.minimalCost(7), 9);

        TestUtil.test(obj.minimalCost(200), 18);
    }
}


