import java.util.*;
import my.util.*;

public class TaroFillingAStringDiv2 {

    public int getNumber(String s) {

        int len = s.length();
        char[] str = s.toCharArray();

        while (true) {
            boolean unknown = false;
            for (int i = 0; i < len; i++) {
                if (str[i] == '?') {
                    unknown = true;
                    char ch1 = safeChar(str, i-1);
                    char ch2 = safeChar(str, i);
                    char ch3 = safeChar(str, i+1);

                    if (ch3 == '?')
                        str[i] = ch1 == 'A' ? 'B' : 'A';
                    else if (ch1 == 'A' && ch3 == 'A')
                        str[i] = 'B';
                    else if (ch1 == 'B' && ch3 == 'B')
                        str[i] = 'A';
                    else if (ch1 == '-')
                        str[i] = ch3 == 'A' ? 'B' : 'A';
                    else if (ch3 == '+')
                        str[i] = ch1 == 'A' ? 'B' : 'A';
                    else
                        str[i] = 'A';
                }
            }

            if (!unknown) break;
        }

        int res = 0;
        for (int i = 0; i+1 < len; i++) {
            if (str[i] == str[i+1]) {
                res++;
            }
        }

        return res;
    }

    private char safeChar(char[] str, int index) {
        if (index < 0) {
            return '-';
        }
        if (str.length <= index) {
            return '+';
        }
        return str[index];
    }

    public static void main(String[] args) {
        TaroFillingAStringDiv2 obj = new TaroFillingAStringDiv2();

        TestUtil.test(obj.getNumber(
                    "ABAA"), 1);
        // There is initially one pair of consecutive digits that are equal in this case. There is no characters that Taro has to replace, hence the answer is 1.
        //
        TestUtil.test(obj.getNumber(
                    "??"), 0);

        TestUtil.test(obj.getNumber(
                    "A?A"), 0);

        TestUtil.test(obj.getNumber(
                    "A??B???AAB?A???A"), 3);

        TestUtil.test(obj.getNumber(
                    "?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?"), 10);
    }
}

