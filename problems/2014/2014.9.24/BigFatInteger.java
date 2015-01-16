// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class BigFatInteger {


    public int minOperations(int A, int B) {

        int[] primes = getPrimes(50);
        int[] operations = new int[primes[primes.length-1]+1];

        double tmp = Math.pow(A, B);
        for (int i : primes) {
            while (tmp > 1) {
                if (tmp % i == 0) {
                    tmp /= (double)i;
                    ++operations[i];
                } else {
                    break;
                }
            }
        }

        /*
        System.out.println("\noperation:");
        for (int i : operations) {
            System.out.print(i+" ");
        }
        System.out.println();
        */

        int result = 0;
        int x = 1;
        boolean base = true;
        for (int i = operations.length-1; i >= 0; i--) {

            if (operations[i] == 0) {
                continue;
            }

            if (operations[i] == 1) {
                result++;
                continue;
            } 

            result+=2;
            if (operations[i] % 2 == 0) {
                if (base) {
                    result++;
                    base = false;
                } else {
                    base = true;
                }
            }
        }

        return result;
    }

    private int[] getPrimes(int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= max; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && i != 1) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /*

    private static void test(int exp, int res) {
        System.out.println(String.format("[EXP == RES] %d == %d\n", exp, res));
    }
    
    public static void main(String[] args) {
        BigFatInteger obj = new BigFatInteger();

        test(2, obj.minOperations(6, 1));
        test(4, obj.minOperations(162, 1));
        test(5, obj.minOperations(999983, 9));
        test(8, obj.minOperations(360, 8));
    }
}
