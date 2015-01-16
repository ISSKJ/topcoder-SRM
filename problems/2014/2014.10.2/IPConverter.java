// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class IPConverter {

    public String[] possibleAddresses(String unknown) {
        int size = unknown.length()+3;

        ArrayList<String> list = new ArrayList<String>();

        String tmp;
        for (int i = 1; i < size; i++) {
            for (int j = i+2; j < size; j++) {
                for (int k = j+2; k < size; k++) {
                    tmp = getIP(unknown, i, j, k);
                    if (tmp != null) list.add(tmp);
                }
            }
        }

        String[] res = new String[list.size()];
        list.toArray(res);

        return res;
    }

    private String getIP(String unknown, int first, int second, int third) {
        char[] ch = new char[unknown.length()+3];
        int index = 0;
        ch[first] = ch[second] = ch[third] = '.';
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '.') {
                ch[i] = unknown.charAt(index++);
            }
        }

        String ip = new String(ch); 
        String[] mask = ip.split("\\.");

        if (mask.length != 4) {
            return null;
        }

        try {
            boolean valid = true;
            int number;
            for (String str : mask) {
                number = Integer.parseInt(str);
                if (number > 255 || number < 0) {
                    valid = false;
                }
                if (str.charAt(0) == '0' && str.length() > 1) {
                    valid = false;
                }
            }

            return valid ? ip : null;

        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void test(String[] exp, String[] res) {
        System.out.println("[EXP]");
        for (String s : exp) System.out.print(s+" ");
        System.out.println("\n[RES]");
        for (String s : res) System.out.print(s+" ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        IPConverter obj = new IPConverter();

        test(new String[]{ "1.90.24.26",  "1.90.242.6",  "19.0.24.26",  "19.0.242.6",  "190.2.4.26",  "190.2.42.6",  "190.24.2.6" },
                obj.possibleAddresses("1902426"));

        test(new String[]{ },
                obj.possibleAddresses("000"));

        test(new String[]{ },
                obj.possibleAddresses(""));

        test(new String[]{ "0.18.62.90",  "0.186.2.90",  "0.186.29.0" },
                obj.possibleAddresses("0186290"));

        test(new String[]{ "1.1.111.111",  "1.11.11.111",  "1.11.111.11",  "1.111.1.111",  "1.111.11.11",  "1.111.111.1",  "11.1.11.111",  "11.1.111.11",  "11.11.1.111",  "11.11.11.11",  "11.11.111.1",  "11.111.1.11",  "11.111.11.1",  "111.1.1.111",  "111.1.11.11",  "111.1.111.1",  "111.11.1.11",  "111.11.11.1",  "111.111.1.1" },
                obj.possibleAddresses("11111111"));

        test(new String[]{ },
                obj.possibleAddresses("3082390871771742784899852251737850570843857369760"));

        test(new String[]{ "2.56.255.255",  "25.6.255.255",  "25.62.55.255" },
                obj.possibleAddresses("256255255"));
    }
}
