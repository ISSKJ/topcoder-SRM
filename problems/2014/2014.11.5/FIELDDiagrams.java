// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class FIELDDiagrams {

    public long countDiagrams(int fieldOrder) {

        int[][] box = new int[31][31];
        box[0][fieldOrder] = 1;
        for (int i = 1; i <= fieldOrder+1; i++) {
            for (int j = 1; j <= fieldOrder-i+1; j++) {
                for (int k = j; k <= fieldOrder; k++) {
                    box[i][j] += box[i-1][k];
                }
            }
        }

        int res = 0;
        for (int i = 1; i < box.length; i++) {
            for (int j = 1; j < box.length; j++) {
                res += box[i][j];
            }
        }


        return res;
    }

    public static void test(long res, long exp) {
        System.out.println("[EXP]=[RES]:"+exp+"="+res);
    }

    public static void main(String[] args) {
        FIELDDiagrams obj = new FIELDDiagrams();

        test(obj.countDiagrams(2), 4);
        // There are four possible FIELD diagrams for fieldOrder equal to 2, corresponding to partitions: (1), (2), (1, 1), (2,1). 
        // They are shown in the picture below. There white stands for unused space in a row and red for boxes, corresponding to FIELD diagrams. 

        test(obj.countDiagrams(3), 13);

        test(obj.countDiagrams(5), 131);
    }
}
