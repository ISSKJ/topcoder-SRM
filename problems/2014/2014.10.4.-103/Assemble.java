
import java.util.*;


public class Assemble {

    int[][] cache = new int[100][100];
    /**
     * 答え見ても分からない。。
     * とりあえず優勝者のコードをそのままコピペ
     */
    public int minCost(int[] con) {
        int len = con.length;
        cache = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                cache[i][j] = -1;
            }
        }

        return solve(con, 0, len-1);
    }

    private int solve(int[] con, int index, int b) {
        if (index == b) {
            return 0;
        }
        if (index+1 == b) {
            return 0;
        }

        if (cache[index][b] != -1) {
            return cache[index][b];
        }

        int minCost = -1;
        for (int k = index+1; k < b; k++) {

            int cost = 
                (con[index] + (k-index)) * con[k] * (con[b] + (b-k)) 
                + solve(con, index, k)
                + solve(con, k, b);

            //System.out.println(String.format("(%d + %d) * %d * (%d + %d)", 
            //            con[index], (k-index), con[k], con[b], (b-k)));


            // is first
            if (k == index+1) {
                minCost = cost;
            }
            if (cost < minCost) {
                minCost = cost;
            }
        }

        cache[index][b] = minCost;
        return cache[index][b];

    }



    /*=================================================================================
     * ここから悪戦苦闘した結果のコード
     *
    public int minCost(int[] con) {
        int len = con.length;
        int minCost = Integer.MAX_VALUE;


        int[] tmp = new int[len];

        for (int i = 0; i < len; i++) {
        System.arraycopy(con, 0, tmp, 0, len);
        int front = con[i];

            int cost = 0;
            int size = 1;
            System.out.println("=== " + i + " ===");
            for (int j = i; j < len; j++) {

                if (j+2 < len) {
                    if (tmp[j+1] == -1 || tmp[j+2] == -1) {
                        break;
                    }
                    cost += (front + size) * tmp[j+1] * (tmp[j+2] + 1);
                    System.out.println(String.format("(%d + %d) * %d * (%d + %d)", 
                                front, size, tmp[j+1], tmp[j+2], 1));
                    tmp[j+1] = -1;
                } else {
                    if (tmp[j-1] == -1 || tmp[len-1] == -1 || tmp[j-2] == -1) {
                        break;
                    }
                    front = tmp[len-1];
                    cost += (front + size) * tmp[j-1] * (tmp[j-2] + 1);
                    System.out.println(String.format("(%d + %d) * %d * (%d + %d)", 
                                front, size, tmp[j-1], tmp[j-2], 1));
                    tmp[j-1] = -1;
                }
                size++;
            }

            minCost = Math.min(minCost, cost);

            System.out.println("COST:"+cost);

        }


        return minCost;
    }

    private ArrayList<Integer> getSerial(int[] con, int index) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = index; i < con.length; i++) {
            list.add(con[i]);
        }
        for (int i = 0; i < index; i++) {
            list.add(con[i]);
        }
        return list;
    }
    ==========================================================================================*/

    private static void test(int res, int exp) {
        System.out.println("[EXP]:"+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {
        Assemble obj = new Assemble();


        test(obj.minCost(
                    new int[]{19,50,10,39}), 19400);
        // The input represents 3 components, A B and C. A has 19 inputs and 50 outputs. There are only two ways to assemble 3 components:
        // Plan 1. join A to B, then AB to C. This will cost (19+1)*50*(10+1) to join A to B, plus (19+2)*10*(39+1) to join AB to C. Total = 19,400
        // Plan 2. join B to C, then A to BC. This will cost (50+1)*10*(39+1) to join B to C, plus (19+1)*50*(39+2) to join A to BC. Total = 61,400

        test(obj.minCost(
                    new int[]{13,18,24,11,25,100,93,92,79}), 407518);


        test(obj.minCost(
                    new int[]{1,1,1,1,1,1,1,1,1}), 59);
        // The nine elements of input represent 8 idendical components. The cheapest way to assemble them is first to join 4 adjacent pairs at a cost of 4 each, then to join two adjacent pairs of 2-component assemblies at a cost of 9 each, and finally to join the remaining pair of 4-component assemblies at a cost of 25. Total cost = 4*4 + 2*9 + 25 = 59.
    }
}
