
import java.util.*;


public class ClapLight {

    public int threshold(int[] background) {
        int len = background.length;
        int maxCount = (len/2)+1;

        int res = 0;
        while (true) {
            boolean turnOn = false;
            int cnt = 0;
            res++;

            for (int i : background) {
                if (i < res) cnt++;
            }

            if (maxCount <= cnt) {
                for (int i = 0; i+3 < len; i++) {
                    if (background[i] < res &&  background[i+1] >= res && background[i+2] >= res && background[i+3] < res) {
                        turnOn = true;
                    }
                }
                if (turnOn) continue;

                break;
            }
        }

        return res;
    }

    private static void test(int res, int exp) {
        System.out.println("[EXP]:"+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {
        ClapLight obj = new ClapLight();

        test(obj.threshold(
                    new int[]{6,6,6,6,6}), 7);
        // The threshold must be at least 7 to exceed more than 50% of the samples, 
        // and with the threshold set at 7 every reading will be classified "low" and the light will not be triggered.
 

        test(obj.threshold(
                    new int[]{ 5,8,7,6,12,8,4,3,2,6 }), 9);
        // The threshold must exceed at least 6 of these values to satisfy the 50% rule. 
        // So it must be at least 7. But with the threshold set at 7 the sequence 5, 8, 7, 6 would trigger the light. 
        // A threshold of 8 will allow the sequence 6,12,8,4 to trigger the light. A threshold of 9 will never cause this sequence to trigger the light.

        test(obj.threshold(
                    new int[]{8,8,8,1,1,1,1,1,1,1,1,1,1,1,2,1}), 2);
        //Remember that the high noise levels must be both preceded and followed by low noise levels to trigger the light.

        test(obj.threshold(
                    new int[]{921,1,5,900,8,813,3,3,3,3,3,3,3,813,813}), 4);
    
    }
}
