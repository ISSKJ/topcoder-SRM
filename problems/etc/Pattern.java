// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class Pattern {

    public String[] pattern(int col) {
        ArrayList<String> list = new ArrayList<>();
        
        // col == 4
        // n == 0 oooo oooo oooo oooo
        // n == 1 ooox ooxo oxoo xooo
        // n == 2 ooxx oxxo xxoo xoox
        // n == 3 oxxx xoxx xxox xxxo
        // n == 4 xxxx xxxx xxxx xxxx
        for (int i = 0; i <= col; i++)
            all(list, col, i);


        // convert 
        int size = list.size();
        String[] res = new String[list.size()];

        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void all(ArrayList<String> ret, int col, int n) {
    }


    public static void main(String[] args) {

        Pattern obj = new Pattern();
        String[] res = obj.pattern(4);

        for (String s : res) {
            System.out.println(s);
        }
        System.out.println("count:"+res.length);
    }
}
