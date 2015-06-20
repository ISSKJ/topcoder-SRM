// BEGIN CUT HERE

// END CUT HERE

public class WritingWords {

    public int write(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            res += ch - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        WritingWords obj = new WritingWords();

        TestUtil.test(obj.write(
                    "A"), 1);
        // One tap types the letter A.

        TestUtil.test(obj.write(
                    "ABC"), 6);
        // To type ABC, Ciel will do the following:
        // Tap the button once to type A.
        // Tap the button twice to type B.
        // Tap the button three times to type C.
        // The total number of taps is 1+2+3 = 6.

        TestUtil.test(obj.write(
                    "VAMOSGIMNASIA"), 143);

        TestUtil.test(obj.write(
                    "TOPCODER"), 96);

        TestUtil.test(obj.write(
                    "SINGLEROUNDMATCH"), 183);

        TestUtil.test(obj.write(
                    "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"), 1300);

    }
}
