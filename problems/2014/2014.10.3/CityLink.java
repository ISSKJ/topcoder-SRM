// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class CityLink {


    public int timeTaken(int[] x, int[] y) {

        int len = x.length;
        int[][] distance = new int[len][len];

        // default is max distance
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        // get distance
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                distance[i][j] = getDistance(x[i], y[i], x[j], y[j]);
            }
        }

        /* 
         * calculate minimum distance
         * using floyd graph algorithms
         *
         * http://www.cs.cornell.edu/~wdtseng/icpc/notes/graph_part3.pdf
         *
         * http://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
         */   
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    distance[j][k] = Math.min(distance[j][k], Math.max(distance[j][i], distance[i][k]));
                }
            }
        }

        // now all of the i-th x-y distance is the shortest!!
        // get how long does it take to construct.
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                max = Math.max(max, distance[i][j]);
            }
        }

        return max;
    }


    private int getDistance(int x1, int y1, int x2, int y2) {
        // horizontal
        if (x1 == x2) {
            return (int)((Math.abs(y1-y2)+1)/2.0);
        }
        // vertical
        if (y1 == y2) {
            return (int)((Math.abs(x1-x2)+1)/2.0);
        }
        // get the longest distance.
        return (int)(Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
    }



    public static void test(int exp, int res) {
        System.out.println("[EXP]:"+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {
        CityLink obj = new CityLink();

        test(5, obj.timeTaken(
                    new int[]{0,5},
                    new int[]{0,5}));	
        //The road north from (0,0) will intersect the road west from (5,5) at t = 5.

        test(45, obj.timeTaken(
                    new int[]{0,0},
                    new int[]{30,-59}));

        test(1, obj.timeTaken(
                    new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
                        27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49},	
                        new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
                            27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49}));

        test(0, obj.timeTaken(
                    new int[]{100000},
                    new int[]{-1000000}));

        test(73418, obj.timeTaken(
                    new int[]{1593,-88517,14301,3200,6,-15099,3200,5881,-2593,11,57361,-92990},
                    new int[]{99531,-17742,-36499,1582,46,34001,-19234,1883,36001,0,233,485}));

    }
}
