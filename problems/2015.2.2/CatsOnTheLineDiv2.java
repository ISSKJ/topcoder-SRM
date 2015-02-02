import java.util.*;
import my.util.*;

public class CatsOnTheLineDiv2 {

    public String getAnswer(int[] pos, int[] count, int time) {

        sort(pos, count);

        int maxCats = 0;
        for (int i : count) {
            maxCats += i;
        }
        int[][] cats = new int[maxCats][3000];

        int offset = 0;

        for (int i = 0; i < pos.length; i++) {
            offset = Math.min(offset, pos[i] - time);
        }
        offset = Math.abs(offset);

        int nn = 0;  
        for (int i = 0; i < pos.length; i++) {
            for (int n = 0; n < count[i]; n++) {

                for (int k = 0; k <= time; k++) {
                    cats[nn][pos[i]+offset+k] = 1;
                }
                for (int k = 0; k <= time; k++) {
                    cats[nn][pos[i]+offset-k] = 1;
                }

                cats[nn][pos[i]+offset] = 2;

                nn++;
            }
        }

        for (int start = 0; start < cats[0].length-cats.length; start++) {

            boolean possible = true;

            for (int x = 0; x < cats.length; x++) {
                if (cats[x][start+x] == 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                return "Possible";
            }
        }

        return "Impossible";
    }

    private void sort(int[] pos, int[] count) {

        for (int i = 0; i < pos.length; i++) {

            for (int j = 0; j < pos.length; j++) {
                if (pos[i] < pos[j]) {
                    int p, c;
                    p = pos[i];
                    c = count[i];

                    pos[i] = pos[j];
                    count[i] = count[j];

                    pos[j] = p;
                    count[j] = c;
                }
            }
        }
    }

    public static void main(String[] args) {

        CatsOnTheLineDiv2 obj = new CatsOnTheLineDiv2(); 

        TestUtil.test(obj.getAnswer(
                    new int[]{0},
                    new int[]{7},
                    3), "Possible");
        // There are 7 cats sitting at the origin in this case. There are also 7 different points that cats can reach in 3 minutes, so each cat can occupy a unique point. Thus, the answer is "Possible".
        //  3 2 1 0 1 2 3
        //        1  
        //        1
        //        1
        //        1
        //        1 
        //        1 
        //        1 
        //  3 2 1 0 1 2 3
        //        1  
        //      1
        //    1
        //  1 
        //              1 
        //            1 
        //          1 

        TestUtil.test(obj.getAnswer(
                    new int[]{0},
                    new int[]{8},
                    2), "Impossible");
        // Unlike the first test case, in this case there are 8 cats for 7 available points. Thus, the answer is "Impossible".

        TestUtil.test(obj.getAnswer(
                    new int[]{0, 1},
                    new int[]{3, 1},
                    0), "Impossible");
        //  3 2 1 0 1 2 3
        //        1  
        //        1
        //        1
        //          1 
        //  3 2 1 0 1 2 3
        //        1  
        //      1
        //    1
        //          1 

        TestUtil.test(obj.getAnswer(
                    new int[]{5, 0, 2},
                    new int[]{2, 3, 5},
                    2), "Impossible");
        // n  0 1 2 3 4 5 6 7
        //    2 1 0 1 2 3 4 5
        // 0                1
        // 1                1
        // 2      1
        // 3      1
        // 4      1
        // 5          1
        // 6        1
        // 7      1
        // 8    1
        // 9  1
        //    2 1 0 1 2 3 4 5
        //                  1
        //                  1
        //        1
        //      1
        //    1
        //            1
        //          1
        //        1
        //            1
        //            1

        TestUtil.test(obj.getAnswer(
                    new int[]{5, 1, -10, 7, 12, 2, 10, 20},
                    new int[]{3, 4, 2, 7, 1, 4, 3, 4},
                    6) , "Possible");
    }
}
