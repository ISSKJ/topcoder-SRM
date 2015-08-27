// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class FewestFactors {

    public int number(int[] digits) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (i == j) continue;
                int sum = swapAndSum(digits, i, j);
                min = Math.min(dividerCount(sum), min);
            }
        }
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (i == j) continue;
                int sum = swapAndSum(digits, i, j);
                if (min == dividerCount(sum)) {
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        return list.get(0);
    }

    private int dividerCount(int num) {
        int tmp = 0;
        int count = 0;
        while (tmp <= num) {
            tmp++;
            if (num % tmp == 0) {
                count++;
            }
        }
        return count;
    }


    private int swapAndSum(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        int sum = 0;
        for (int n = 0; n < array.length; n++) {
            sum += array[n] * (int)Math.pow(10, n);
        }
        return sum;
    }


    public static void main(String[] args) {
        FewestFactors obj = new FewestFactors();

        TestUtil.test(obj.number(
                    new int[]{1, 2}), 21);

        // Using the digits 1 and 2 we can build the numbers 12
        // (which has 6 factors: 1, 2, 3, 4, 6 and 12) and 21
        // (which has 4 factors: 1, 3, 7 and 21). So we return
        // 21, which is the number among them having the smallest
        // number of factors.

        TestUtil.test(obj.number(
                    new int[]{6, 0}), 6);

        // Note that we can use 0 as a leading zero, giving the
        // number 6 that has 4 factors (1, 2, 3 and 6), less than
        // the alternative 60 that has 12 factors.

        TestUtil.test(obj.number(
                    new int[]{4, 7, 4}), 447);

        // Note that digits may contain duplicate digits.
        // We have to use each digit as many times as it appears
        // in the input.

        TestUtil.test(obj.number(
                    new int[]{1, 3, 7, 9}), 1973);

        TestUtil.test(obj.number(
                    new int[]{7, 5, 4, 3, 6}), 36457);

        TestUtil.test(obj.number(
                    new int[]{1,2,4}), 241);

        // Both 241 and 421 are prime numbers, and thus have exactly 2 factors 
        // (241 has the factors 1 and 241, while 421 has the factors 1 and 421). 
        // All other numbers that we can build from these digits (124, 142, 214 and 412) 
        // have more than 2 factors. We have to use the tie-breaker here 
        // and return the smaller of (241, 421).
    }
}
