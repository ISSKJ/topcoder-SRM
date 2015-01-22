import java.util.*;


public class GameOfStones {

    public int count(int[] stones) {
        int avg = getAverage(stones);

        int diff = 0;
        for (int i : stones) {
            int tmp = Math.abs(i - avg);

            diff += tmp;

            if (tmp % 2 != 0) {
                return -1;
            }
        }

        double count = (double)diff / 4.0;
        double round = Math.round(count); 

        if (count != round) {
            return -1;
        }

        return (int)count;
    }

    private int getAverage(int[] stones) {
        int max = 0;
        for (int i : stones) {
            max += i;
        }
        double tmp = (double)max / (double)stones.length;

        return (int)Math.round(tmp);
    }

    private static void test(int res, int exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }

    public static void main(String[] args) {

        GameOfStones obj = new GameOfStones();

        test(obj.count(
                    new int[]{7, 15, 9, 5}), 3);
        // There are four piles of stones. There are 7 stones in pile number 0, 
        // 15 stones in pile number 1, 9 stones in pile number 2, and 
        // 5 stones in pile number 3. One optimal solution looks as follows: 
        // First, Limak will move a pair of stones from pile 1 to pile 0. 
        // Afterwards, Limak will twice move a pair of stones from pile 1 to pile 3. 
        // After these 3 actions, each pile contains exactly 9 stones.

        test(obj.count(
                    new int[]{10, 16}), -1);
        // It can be proven that Limak can't make these two piles equal.

        test(obj.count(
                    new int[]{2, 8, 4}), -1);

        test(obj.count(
                    new int[]{17}), 0);
        // Limak doesn't need to perform any actions. There is only one pile and it means that all piles already have the same size.

        test(obj.count(
                    new int[]{10, 15, 20, 12, 1, 20}), -1);

    }
}
