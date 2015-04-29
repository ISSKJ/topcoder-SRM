public class LuckyTicketSubstring {

    public int maxLength(String s) {

        int n = s.length()/2;
        String left, right, target;
        boolean found;
        int res = 0;

        while (n > 0) {
            found = false;

            for (int i = 0; i <= s.length() - (n*2); i++) {
                target = s.substring(i, i+n*2);
                left = target.substring(0, n);
                right = target.substring(n);

                if (calc(left) == calc(right)) {
                    res = n * 2;
                    break;
                }
            }
            if (res > 0) {
                break;
            }
            n--;
        }
        return res;
    }

    public int calc(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }

    public int getInt(String s, int index) {
        return Integer.parseInt(String.valueOf(s.charAt(index)));
    }

    public static void test(int res, int exp) {
        System.out.println("[EXP]="+exp+" [RES]="+res);
    }

    public static void main(String[] args) {

        LuckyTicketSubstring obj = new LuckyTicketSubstring();


        test(obj.maxLength(
                    "123231"),
                6);
        // The entire string, 123231, is a lucky ticket because the first 3 digits sum up to 1+2+3=6, and the last 3 digits sum up to 2+3+1=6.

        test(obj.maxLength(
                    "74233285"),
                4);
        // 4233 is the longest lucky ticket here.

        test(obj.maxLength(
                    "986561517416921217551395112859219257312"),
                36);

        test(obj.maxLength(
                    "1"),
                0);

        test(obj.maxLength(
                    "112"),
                2);
    }
}
