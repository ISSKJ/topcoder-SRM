
import java.util.*;
import my.util.*;


public class TaroCoins {

    private ArrayList<Double> min = new ArrayList<Double>();

    public long getNumber(long N) {

        int n = 0;
        double val = 0;

        ArrayList<Long> list = new ArrayList<Long>();

        while (true) {
            val = Math.pow(2, n);
            if (val > N) {
                break;
            }
            list.add((long)val);
            n++;
        }

        System.out.println(list);

        int size = list.size();
        if (size == 1) {
            return (long)size;
        }
        long res = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                res += possible(N, list.get(i), list.get(j));
            }
        }

        return res;
    }

    private long possible(long N, long c1, long c2) {
        System.out.println(String.format("C1:%d C2:%d", c1, c2));

        long res = N - (c2 + c1);
        if (res < 0) {
            return 0;
        }

        if (res == 0) {
            System.out.println("match 1");
            return 1;
        }

        if (N % res == 0) {
            System.out.println("match 2");
            return 1;
        }

        if (res % c1 == 0 || res % c2 == 0) {
            System.out.println("match 3");
            return 1;
        }




        return 0;
    }

    public static void main(String[] args) {

        TaroCoins obj = new TaroCoins();

        TestUtil.test(obj.getNumber(1), 1);
        // The only possible way to represent N in this case is to use one coin of value 1.

        TestUtil.test(obj.getNumber(6), 3);
        // The following three representations are possible in this case: {1, 1, 2, 2}, {1, 1, 4} and {2, 4}
        // (1, 1, 1, 1, 2)
        // (1, 1, 2, 2)
        // (1, 1, 4)
        // (2, 4)

        TestUtil.test(obj.getNumber(47), 2);

        /*
        TestUtil.test(obj.getNumber(256), 9);

        TestUtil.test(obj.getNumber(8489289), 6853);

        TestUtil.test(obj.getNumber(1000000000), 73411);
        */

    }
}
