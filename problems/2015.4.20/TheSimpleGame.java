public class TheSimpleGame {

    public int count(int n, int[] x, int[] y) {

        int res = 0;
        int minX, minY;
        for (int i = 0; i < x.length; i++) {
            minX = Math.min(n - x[i], x[i] - 1);
            minY = Math.min(n - y[i], y[i] - 1);
            res += minX + minY;
        }

        return res;
    }

    public static void test(int res, int exp) {
        System.out.println("[EXP]="+exp+" [RES]="+res);
    }

    public static void main(String[] args) {
        TheSimpleGame obj = new TheSimpleGame();
        test(obj.count(
                    4,
                    new int[]{2},
                    new int[]{3}), 2
            );
        // You need two moves to put the only checker to cell (1, 4).
        test(obj.count(
                    3,
                    new int[]{2, 2, 1, 3},
                    new int[]{2, 2, 3, 1}), 4);

        // For the first two checkers you can choose any of the four corners.
        test(obj.count(
                    7,
                    new int[]{7, 1, 7, 7, 1, 7, 1},
                    new int[]{7, 1, 1, 1, 1, 7, 7}), 0);

        // All checkers are already in the corners.
    }
}

