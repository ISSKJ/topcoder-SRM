import java.util.*;

public class ChristmasTreeDecoration {

    public int solve(int[] col, int[] x, int[] y) {

        int res = 0;
        for (int j = 0; j < x.length; j++) {
            int tree1 = col[x[j]-1];
            int tree2 = col[y[j]-1];

            if (tree1 != tree2) {
                res++;
            }
        }

        int num = col.length-1;

        return num <= res ? 0 : num - res;
    }

    private static void test(int res, int exp) {
        System.out.println(String.format("\n[EXP]=%d\n[RES]=%d\n", exp, res));
    }


    public static void main(String[] args) {
        ChristmasTreeDecoration obj = new ChristmasTreeDecoration();

        test(obj.solve(
                    new int[]{1,1,2,2},
                    new int[]{1,2,3,4},
                    new int[]{2,3,4,1}), 1);
        // We have four stars. Stars 1 and 2 have the same color, and stars 3 a 4 have the same color. 
        // There are four pairs of stars we may connect: 1-2, 2-3, 3-4, and 4-1. 
        // One optimal solution is to use the following ribbons: 2-3, 3-4, and 4-1. 
        // Two of these are beautiful (2-3 and 4-1) and only one (3-4) is not beautiful.
        //
        // same: 1-2, 3-4 different: 2-3, 4-1

        test(obj.solve(
                    new int[]{1,1,2,2},
                    new int[]{1,2,3,4,1,2},
                    new int[]{2,3,4,1,3,4}), 0);
        // Now we can have three beautiful ribbons.
        // same: 1-2, 3-4 different: 2-3, 4-1, 1-3, 2-4

        test(obj.solve(
                    new int[]{50,50,50,50},
                    new int[]{1,2,3,1,1,2},
                    new int[]{2,3,4,4,3,4}), 3);
        // All stars have the same color. Regardless of how we attach the ribbons, none of them will be beautiful.

        test(obj.solve(
                    new int[]{1,4,2,3},
                    new int[]{1,2,3},
                    new int[]{2,3,4}), 0);

        test(obj.solve(
                    new int[]{1,1,1,2,2,2,3,3,3,4,4,4},
                    new int[]{1,2,3,4,5,6,7,8,9,10,11,12,1,1,1,1,1,1},
                    new int[]{2,3,1,5,6,4,8,9,7,11,12,10,5,7,12,11,6,4}), 5);


    }
}
