import java.util.*;

public class ChristmasTreeDecorationDiv2 {

    public int solve(int[] col, int[] x, int[] y) {

        int res = 0;
        for (int j = 0; j < x.length; j++) {
            int tree1 = col[x[j]-1];
            int tree2 = col[y[j]-1];

            if (tree1 != tree2) {
                res++;
            }
        }
        return res;
    }

    private static void test(int res, int exp) {
        System.out.println(String.format("\n[EXP]=%d\n[RES]=%d\n", exp, res));
    }


    public static void main(String[] args) {
        ChristmasTreeDecorationDiv2 obj = new ChristmasTreeDecorationDiv2();

        test(obj.solve(
                    new int[]{1,2,3,3},
                    new int[]{1,2,3},
                    new int[]{2,3,4}), 2);
        // There are two beautiful ribbons: the one that connects stars 1 and 2, and the one that connects stars 2 and 3. The other ribbon is not beautiful because stars 3 and 4 have the same color.

        test(obj.solve(
                    new int[]{1,3,5},
                    new int[]{1,3},
                    new int[]{2,2}), 2);

        test(obj.solve(
                    new int[]{1,1,3,3},
                    new int[]{1,3,2},
                    new int[]{2,1,4}), 2);

        test(obj.solve(
                    new int[]{5,5,5,5},
                    new int[]{1,2,3},
                    new int[]{2,3,4}), 0);

        test(obj.solve(
                    new int[]{9,1,1},
                    new int[]{3,2},
                    new int[]{2,1}), 1);

        test(obj.solve(
                    new int[]{21, 21, 37, 14, 37, 8, 8, 37, 14, 8, 8, 21, 21, 8, 21, 21, 8, 14, 21, 14, 14, 21, 8, 21, 21, 8, 21, 21, 8, 37, 37, 14, 21, 8, 8, 37, 21, 37, 21, 14}, 
                    new int[]{15, 37, 5, 8, 6, 24, 21, 30, 40, 23, 30, 16, 39, 23, 30, 31, 26, 2, 30, 18, 40, 26, 11, 8, 22, 21, 8, 17, 10, 3, 9, 9, 6, 14, 13, 36, 25, 35, 20}, 
                    new int[]{23, 23, 19, 26, 27, 38, 12, 31, 6, 7, 2, 24, 31, 24, 27, 4, 37, 1, 21, 29, 34, 39, 1, 32, 5, 33, 19, 31, 14, 8, 4, 28, 25, 12, 8, 35, 35, 18, 11}), 32);

    }
}
