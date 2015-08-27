// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class CandyShop {

    int[][] matrix;

    int tmp;

    public int countProbablePlaces(int[] X, int[] Y, int[] R) {

        matrix = new int[250][250];

        tmp = 0;
        for (int i = 0; i < R.length; i++) {
            moveR(X[i], Y[i], R[i]);
            initMatrix();
        }

        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (checkRound(i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void initMatrix() {
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix.length; j++) 
                continue;
    }

    private boolean checkRound(int x, int y) {
        return (matrix[x][y] > 0 &&
                matrix[x+1][y] > 0 &&
                matrix[x-1][y] > 0 &&
                matrix[x][y+1] > 0 &&
                matrix[x][y-1] > 0);
    }

    private void moveR(int x, int y, int count) {
        if (count >= 0) {
            moveR(x, y, count-1);
            moveR(x-1, y, count-1);
            moveR(x+1, y, count-1);
            moveR(x, y-1, count-1);
            moveR(x, y+1, count-1);
        }
        move(x, y);
    }

    private void move(int x, int y) {
        matrix[102+x][102+y]++;
    }


    public static void main(String[] args) {
        CandyShop obj = new CandyShop();

        TestUtil.test(obj.countProbablePlaces(
                    new int[]{0},
                    new int[]{0},
                    new int[]{1}), 5);
        // Manao walked at most 1 unit of distance. Therefore, the shop could be at (0,0) if Manao didn't walk at all and at (1,0), (0,1), (-1,0) or (0,-1) if he walked.

        TestUtil.test(obj.countProbablePlaces(
                    new int[]{0},
                    new int[]{0},
                    new int[]{2}), 13);

        // 8 new locations are introduced if Manao walks another unit of distance.

        TestUtil.test(obj.countProbablePlaces(
                    new int[]{2,3},
                    new int[]{1,-1},
                    new int[]{2,2}), 4);
        // The possible places for the shop are intersections (2,0), (2,-1), (3,0) and (3,1).

        TestUtil.test(obj.countProbablePlaces(
                    new int[]{2,3,5},
                    new int[]{1,-1,0},
                    new int[]{2,2,3}), 3);

        // This is the same situation as in the previous example, but Manao has been to the shop once more. After this visit, (2,-1) is also ruled out from the possibilities list.

        TestUtil.test(obj.countProbablePlaces(
                    new int[]{-100,-100,-100,0,0,0,100,100,100},
                    new int[]{-100,0,100,-100,0,100,-100,0,100},
                    new int[]{1,1,1,1,1,1,1,1,1}), 0);

        // Manao is surely mistaken in his reminiscence.
        TestUtil.test(obj.countProbablePlaces(
                    new int[]{-3,3,5,5},
                    new int[]{4,5,-2,0},
                    new int[]{10,11,8,6}), 33);
    }
}

