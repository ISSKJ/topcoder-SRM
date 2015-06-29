// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class Islands {

    public int beachLength(String[] kingdom) {

        char[][] king = new char[kingdom.length][kingdom[0].length()];

        int res = 0;
        for (int i = 0; i < kingdom.length; i++) {
            for (int j = 0; j < kingdom[0].length(); j++) {
                king[i][j] = kingdom[i].charAt(j);
            }
        }

        for (int i = 0; i < kingdom.length; i++) {
            for (int j = 0; j < kingdom[0].length(); j++) {
                if (king[i][j] == '.') {
                    int c = count(king, i, j);
                    res += c;
                    king[i][j] = '0';
                }
            }
        }
        return res;
    }

    private int count(char[][] cell, int row, int col) {
        char ch = cell[row][col];
        char tmp;
        int cnt = 0;

        if (validate(cell, row, col-1) == '#') {
            cnt++;
            System.out.print("L ");
        }
        if (validate(cell, row, col+1) == '#') {
            cnt++;
            System.out.print("R ");
        }
        /*
        if (validate(cell, row-1, col) == '#') {
            cnt++;
            System.out.print("T1 ");
        }
        if (validate(cell, row-1, col+1) == '#') {
            cnt++;
            System.out.print("T2 ");
        }
        */
        if (validate(cell, row+1, col) == '#') {
            cnt++;
            System.out.print("B1 ");
        }
        if (validate(cell, row+1, col+1) == '#') {
            cnt++;
            System.out.print("B2 ");
        }
        return cnt;
    }
    private char validate(char[][] cell, int row, int col) {
        if (cell.length <= row || row < 0) {
            return 'A';
        }
        if (cell[row].length <= col || col < 0) {
            return 'A';
        }
        return cell[row][col];
    }

    public static void main(String[] args) {
        Islands obj = new Islands();
        TestUtil.test(obj.beachLength(
                    new String[]{".#...#.."}), 4);
        // There are two small islands with water on two sides of each island. 

        TestUtil.test(obj.beachLength(
                    new String[]
                    {"..#.##", 
                     ".##.#.", 
                     "#.#..."}), 19);

        // The example in the problem statement. 

        /*
        TestUtil.test(obj.beachLength(
                    new String[]
                    {"#...#.....",
                     "##..#...#."}), 15);

        TestUtil.test(obj.beachLength(
                    new String[]
                    {"....#.",
                     ".#....",
                     "..#..#",
                     "####.."}), 24);
                     */

    }
}
