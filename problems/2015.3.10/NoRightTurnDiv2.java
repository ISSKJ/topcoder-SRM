// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class NoRightTurnDiv2 {

    public int[] findPath(int[] x, int[] y) {

        int[] res = new int[x.length];

        for (int i = 0; i < x.length; i++) {
            res[i] = findCCWDimension(i, x, y);
        }
        return res;
    }

    private int findCCWDimension(int index, int[] x, int[] y) {

        int dx = x[index];
        int dy = y[index];

        for (int i = 0; i < x.length; i++) {
            if (index == i) continue;
        }
    }

    public static void test(int[] res, int[] exp) {
        System.out.println("\nEXP");
        for (int i : exp) System.out.print(i+" ");
        System.out.println("\nRES");
        for (int i : res) System.out.print(i+" ");
        System.out.println("");
    }

    public static void main(String[] args) {
        NoRightTurnDiv2 obj = new NoRightTurnDiv2();
        test(obj.findPath(
                    new int[]{-10, 0, 10},
                    new int[]{10, -10, 10}), 
                new int[]{0, 1, 2 });

        // The points form a triangle.
        // Any of the following return values will be accepted: {0,1,2},{1,2,0},{2,0,1}

        test(obj.findPath(
                    new int[]{0,0,-3,-3,3,3},
                    new int[]{-1,1,-3,3,-3,3}), 
                new int[]{0, 4, 5, 3, 2, 1 });

        // Here is a picture of the points:
        // Here is an example of a different valid solution. This would correspond to a return value of {1,5,3,2,4,0}

        test(obj.findPath(
                    new int[]{10,9,8,7,6,5,4,3,2,1},
                    new int[]{1,4,9,16,25,36,49,64,81,100}), 
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });

        test(obj.findPath(
                    new int[]{0, 2,-2, 4,-4, 2,-2, 0},
                    new int[]{1, 2, 2, 4, 4, 6, 6, 5}), 
                new int[]{4, 2, 0, 1, 3, 5, 6, 7 });

        test(obj.findPath(
                    new int[]{-76,98,83,58,-15,94,21,55,80,84,-39,-90,-46,100,-80,-49,-2,-70,36,48,88,10,
                        55,-56,22,67,31,81,100,-39,64,-62,-7,45,-82,-24,51,-33,53,11,20,-74,-83,47,
                        9,39,42,63,-97,94},
                        new int[]{-90,68,91,-92,-6,88,99,10,39,-69,-61,-4,71,-5,90,-51,21,-53,-21,-86,41,-9,
                            42,-23,-4,12,94,-59,55,18,70,-88,-86,-17,-97,-33,87,80,91,-80,-79,-79,-78,
                            -99,57,67,-52,-46,61,-10}),
                new int[]{39, 32, 40, 31, 19, 27, 47, 46, 0, 34, 43, 3, 9, 13, 28, 1, 5, 2, 6, 14, 48, 42, 41, 49, 20, 38, 26, 37, 12, 11, 17, 10, 33, 25, 8, 30, 36, 44, 29, 23, 15, 18, 7, 22, 45, 16, 4, 35, 24, 21 });
    }
}


