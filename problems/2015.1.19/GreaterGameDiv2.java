public class GreaterGameDiv2 {

    public int calc(int[] snuke, int[] sothe) {

        int count = 0;
        for (int i = 0; i < snuke.length; i++) {
            if (snuke[i] > sothe[i]) {
                count++;
            }
        }
        return count;
    }

    private static void test(double res, double exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res+"\n");
    }

    public static void main(String[] args) {
        GreaterGameDiv2 obj = new GreaterGameDiv2();

        test(obj.calc(
                    new int[]{1,3},
                    new int[]{4,2}), 1);
        // Snuke loses the first round because 1 is less than 4. Snuke then wins the second round because 3 is greater than 2.

        test(obj.calc(
                    new int[]{1,3,5,7,9},
                    new int[]{2,4,6,8,10}), 0);

        test(obj.calc(
                    new int[]{2},
                    new int[]{1}), 1);

        test(obj.calc(
                    new int[]{3,5,9,16,14,20,15,17,13,2},
                    new int[]{6,18,1,8,7,10,11,19,12,4}), 6);

    }
}
