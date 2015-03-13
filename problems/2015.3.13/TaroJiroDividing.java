import java.util.*;
import my.util.*;

public class TaroJiroDividing {

    public int getNumber(int A, int B) {

        ArrayList<Integer> taroA = new ArrayList<Integer>();
        ArrayList<Integer> jiroB = new ArrayList<Integer>();
        taroA.add(A);
        jiroB.add(B);

        while (A % 2 == 0) {
            A /= 2;
            taroA.add(A);
        }
        while (B % 2 == 0) {
            B /= 2;
            jiroB.add(B);
        }

        int count = 0;
        for (int i : taroA) {
            if (jiroB.contains(i)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        TaroJiroDividing obj = new TaroJiroDividing();

        TestUtil.test(obj.getNumber(
                    8,
                    4), 3);
        // Taro will write the integers {8,4,2,1}. Jiro will write {4,2,1}. The three integers written by both of them are 4, 2, and 1.

        TestUtil.test(obj.getNumber(
                    4,
                    7), 0);

        TestUtil.test(obj.getNumber(
                    12,
                    12), 3);

        TestUtil.test(obj.getNumber(
                    24,
                    96), 4);

        TestUtil.test(obj.getNumber(
                    1000000000,
                    999999999), 0);

    }
}
