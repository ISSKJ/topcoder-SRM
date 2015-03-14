
import java.util.*;
import my.util.*;


public class TaroGrid {

    public int getNumber(String[] grid) {

        int row = grid[0].length();
        int col = grid.length;

        int max = 0;

        for (int i = 0; i < row; i++) {
            char prev = '\0';
            int cnt = 1;
            for (int j = 0; j < col; j++) {
                if (prev == grid[j].charAt(i)) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                prev = grid[j].charAt(i);
            }

            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {

        TaroGrid obj = new TaroGrid();

        TestUtil.test(obj.getNumber(
                    new String[]{"W"}), 1);


        TestUtil.test(obj.getNumber(
                    new String[]{"WB",
                        "BW"}), 1);

        TestUtil.test(obj.getNumber(
                    new String[]{"BWW",
                        "BBB",
            "BWB"}), 3);
        // He can choose the entire leftmost column (i.e., character 0 of each element of grid).

        TestUtil.test(obj.getNumber(
                    new String[]{"BWBW",
                        "BBWB",
            "WWWB",
            "BWWW"}), 3);

        TestUtil.test(obj.getNumber(
                    new String[]{"BWB",
                        "BBW",
            "BWB"}), 3);

        TestUtil.test(obj.getNumber(
                    new String[]{"BBWWBBWW",
                        "BBWWBBWW",
            "WWBBWWBB",
            "WWBBWWBB",
            "BBWWBBWW",
            "BBWWBBWW",
            "WWBBWWBB",
            "WWBBWWBB"}), 2);
        // Note that the chosen cells must be consecutive.

    }
}
