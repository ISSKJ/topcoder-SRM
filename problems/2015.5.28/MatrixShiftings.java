// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class MatrixShiftings {

    public int minimumShifts(String[] mtx, int value) {
        char val = String.valueOf(value).charAt(0);
        int row, col;
        row = mtx[0].length();
        col = mtx.length;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mtx[j].charAt(i) == val) {
                    int tmp = 0;
                    int rowShift = Math.min(j, col-1-j);
                    int colShift = Math.min(i, row-1-i);

                    tmp += rowShift + colShift;

                    int n = row % 2 == 0 ? 0 : 1;
                    int m = col % 2 == 0 ? 0 : 1;

                    // LEFT-TOP
                    if (i < ((row+n)/2) && j < ((col+m)/2)) {
                        System.out.println("left-top");
                    } 
                    // RIGHT-TOP
                    else if (i >= ((row+n)/2) && j < ((col+m)/2)) {
                        tmp += 1;
                        System.out.println("right-top");
                    }
                    // LEFT-BOTTOM
                    else if (i < ((row+n)/2) && j >= ((col+m)/2)) {
                        tmp += 1;
                        System.out.println("left-bottom");
                    }
                    // RIGHT-BOTTOM
                    else if (i >= ((row+n)/2) && j >= ((col+m)/2)) {
                        tmp += 2;
                        System.out.println("right-bottom");
                    }


                    res = Math.min(res, tmp);
                    System.out.println(String.format("%s i:%d j:%d tmp:%d res:%d",
                                mtx[j], i, j, tmp, res));

                    //mtx[j] = new StringBuilder(mtx[j]).replace(i, i+1, "-1").toString();
                    //System.out.println("R:"+mtx[j]);
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        MatrixShiftings obj = new MatrixShiftings();
        TestUtil.test(obj.minimumShifts(
            new String[]{
             "136",
             "427",
             "568",
             "309"}, 2), 2);
// The matrix contains a single entry with value 2. It can be taken to the upper left corner by performing a single top shift and a single left shift.

        TestUtil.test(obj.minimumShifts(
            new String[]{
            "0000",
            "0000",
            "0099"}, 9), 2);
// If we perform a right shift and a bottom shift, the 9 in the lower right corner will appear in the upper left corner as needed. 

        TestUtil.test(obj.minimumShifts(
            new String[]{
            "0123456789"}, 7), 3);
        // Three right shifts will do the trick.

        TestUtil.test(obj.minimumShifts(
            new String[]{
            "555",
            "555"}, 1), -1);
// There are no ones in the given matrix, so no shifts can help.

        TestUtil.test(obj.minimumShifts(
            new String[]{
            "12417727123",
            "65125691886",
            "55524912622",
            "12261288888"}, 9), 6);

    }
}
