import java.util.*;


public class SpecialStrings {

    public String findNext(String current) {

        ArrayList<String> list = new ArrayList<String>();

        int[] indices = new int[current.length()];

        try {
            recursiveLoop(list, indices);
            System.out.println(list);
        } catch (RuntimeException e) {

        }

        return null;
    }

    private void recursiveLoop(ArrayList<String> list, int[] indices) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            sb.append(indices[i]);
        }

        list.add(sb.toString());

        indices[indices.length-1]++;

        for (int i = indices.length-1; i >= 1; i--) {

            if (indices[i] == 2) {
                indices[i] = 0;
                indices[i-1]++;
            }

            if (indices[0] == 2) {
                return;
            }
        }

        recursiveLoop(list, indices);
    }


    private static void test(String res, String exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }

    public static void main(String[] args) {

        SpecialStrings obj = new SpecialStrings();

        test(obj.findNext
                ("01"), "");
        // "01" is the only special string of length 2.


        test(obj.findNext
                ("00101"), "00111");
        // The special strings of length 5 are "00001", "00011", "00101", "00111", "01011", "01111".

        test(obj.findNext
                ("0010111"), "0011011");

        test(obj.findNext
                ("000010001001011"), "000010001001101");

        /*
        test(obj.findNext
                ("01101111011110111"), "01101111011111111");

                */
    }
}
