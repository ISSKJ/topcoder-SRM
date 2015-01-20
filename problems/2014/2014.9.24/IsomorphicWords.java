// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class IsomorphicWords {

    public int countPairs(String[] words) {

        String[] converted = new String[words.length];
        for (int i = 0; i < converted.length; i++) {
            converted[i] = getNumberConversion(words[i]);
            //System.out.println(converted[i]);
        }


        int count = 0;
        for (int i = 0; i < converted.length; i++) {
            for (int j = i+1; j < converted.length; j++) {
                //System.out.println("A:"+converted[i]+" B:"+converted[j]);
                if (converted[i].equals(converted[j])) {
                    count++;
                }
            }
        }
    
        return count;
    }

    private String getNumberConversion(String str) {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (table.containsKey(str.charAt(i))) {
                sb.append(table.get(str.charAt(i)));
            } else {
                table.put(str.charAt(i), index);
                sb.append(table.get(str.charAt(i)));
                index++;
            }
        }

        return sb.toString();
    }

    /*
    public static void test(int exp, int res) {
        System.out.println(exp+" == "+res);
    }
    
    public static void main(String[] args) {
        System.out.println("[exp] == [res]");
        IsomorphicWords obj = new IsomorphicWords();
        test(1, obj.countPairs(new String[] {"abca", "zbxz", "opqr"}));
        test(4, obj.countPairs(new String[] {"aa", "ab", "bb", "cc", "cd"}));
        test(13, obj.countPairs(new String[] 
                    { "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
                        "bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
                        "dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca" }));
    }
    */
}
