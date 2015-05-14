// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class DiagonalDisproportion {

    public int getDisproportion(String[] matrix) {
        int row, col, res1, res2;
        row = matrix[0].length();
        col = matrix.length;

        res1 = res2 = 0;

        for (int i = 0, j = 0; i < col; i++, j++)
            res1 += Integer.parseInt(""+matrix[i].charAt(j));

        for (int i = 0, j = row-1; i < col; i++, j--)
            res2 += Integer.parseInt(""+matrix[i].charAt(j));

        //System.out.println("RES1:"+res1+" RES2:"+res2);
        return res1-res2;
    }

    public static void main(String[] args) {
        DiagonalDisproportion obj = new DiagonalDisproportion();
        TestUtil.test(obj.getDisproportion(
                    new String[]{"190","828","373"}), 1);
        // The sum of the elements of the main diagonal is 1+2+3 = 6.
        // The sum of the elements of the collateral diagonal is 0+2+3 = 5.
        // So, the answer is 6-5 = 1.

        TestUtil.test(obj.getDisproportion(
                    new String[]{"9000","0120","0000","9000"}), -1);

        TestUtil.test(obj.getDisproportion(
                    new String[]{"6"}), 0);

        // The matrix has only one element, and this element lies on both the main and collateral diagonals.

        TestUtil.test(obj.getDisproportion(
                    new String[]{"7748297018","8395414567","7006199788","5446757413","2972498628",
                        "0508396790","9986085827","2386063041","5687189519","7729785238"}), -24);
    }
}
