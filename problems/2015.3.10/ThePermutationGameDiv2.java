// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class ThePermutationGameDiv2 {

    public long findMin(int N) {
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            p[i] = i+1;
        }

        for (int i = 1; i < N; i++) {
            q[i] = p[q[i-1]];
            System.out.print("f(i):"+q[i]+" ");
        }

        System.out.println();

        for (int i = N-1; i > 0; i--) {
            p[i] = i+1;
            q[i] = i+1;
        }

        for (int i = 1; i < N; i++) {
            q[i] = p[q[i-1]];
            System.out.print("f(i):"+q[i]+" ");
        }

        return 1;
    }

    public static void test(long res, long exp) {
        System.out.print("[EXP]="+exp);
        System.out.println(" [RES]="+res);
    }

    public static void main(String[] args) {
        ThePermutationGameDiv2 obj = new ThePermutationGameDiv2();
        test(obj.findMin(
                    2), 2);
        // Bob can choose the permutations {1,2} or {2,1}.
        // If Alice chooses 1, then, Bob can choose the permutation {2,1}, which would would make f(1) = 2.
        // However, if Alice chooses 2, no matter which permutation Bob chooses, Alice will get f(2) = 1.
        // Thus the answer in this case is 2.

        test(obj.findMin(
                    3), 6);
        test(obj.findMin(
                    6), 60);
        test(obj.findMin(
                    11), 27720);
        test(obj.findMin(
                    25), 26771144400L);

    }
}
