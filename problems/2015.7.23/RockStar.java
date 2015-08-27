// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class RockStar {

    public int getNumSongs(int ff, int fs, int sf, int ss) {

        int cnt = ff;

        if (fs != 0) {
            cnt += ss;
            if (fs > sf) {
                cnt += sf * 2 + 1;
            } else {
                cnt += fs * 2;
            }
        }

        if (fs == 0 && ff == 0) {
            cnt += ss + 1;
        }


        return cnt;
    }

    public static void main(String[] args) {

        RockStar obj = new RockStar();

        TestUtil.test(obj.getNumSongs(
                    100,
                    0,
                    0,
                    200), 100);
        // You must begin the album with one of your fast songs by the 3rd restriction. By the 1st restriction, each subsequent song must also now start fast.

        TestUtil.test(obj.getNumSongs(
                    0,
                    0,
                    20,
                    200), 201);
        // Since you do not have any songs that start fast, you may begin the album with a song that starts slow. You can use 201 songs by first using the 200 songs that start slow and end slow, then finishing the album with one song that starts slow and ends fast.

        TestUtil.test(obj.getNumSongs(
                    1,
                    2,
                    1,
                    1), 5);

        TestUtil.test(obj.getNumSongs(
                    192,
                    279,
                    971,
                    249), 999);
    }
}
