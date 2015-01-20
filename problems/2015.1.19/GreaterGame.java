import java.util.*;

public class GreaterGame {

    /**
     * I am a CPU crasher or memory Mo
     *
     */
    public double calc(int[] snuke, int[] sothe) {

        ArrayList<Integer> snukeList = newList(snuke);
        ArrayList<Integer> sotheList = newList(sothe);
        ArrayList<Integer> unknown = new ArrayList<Integer>();

        int unknownSum = 0;
        for (int i : sotheList) {
            if (i == -1) {
                unknownSum++;
            }
        }

        Collections.sort(snukeList, Collections.reverseOrder());
        Collections.sort(sotheList, Collections.reverseOrder());

        for (int i = 1; i <= 100; i++) {
            if (!snukeList.contains(i) && !sotheList.contains(i)) {
                unknown.add(i);
            }
            if (unknown.size() == unknownSum) {
                break;
            }
        }

        // initialize ordering
        sotheList = newList(sothe);

        ArrayList<Double> prob = new ArrayList<Double>();

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int res;

        for (int z = 0; z < 100000; z++) {

            ArrayList<Integer> tmpSnukeList = new ArrayList<Integer>(snukeList);
            Collections.shuffle(tmpSnukeList);

            int[] tmpSothe = new int[sothe.length];
            ArrayList<ArrayList<Integer>> stack = new ArrayList<ArrayList<Integer>>();

            int maxCount = 0;
            int size = unknown.size();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.arraycopy(sothe, 0, tmpSothe, 0, sothe.length);
                ArrayList<Integer> tmpUnknown = new ArrayList<Integer>(unknown);
                Collections.shuffle(tmpUnknown);
                for (int j = 0; j < sothe.length; j++) {
                    if (tmpSothe[j] == -1) {
                        tmpSothe[j] = tmpUnknown.get(0);
                        tmpUnknown.remove(new Integer(tmpSothe[j]));
                    }
                }

                ArrayList<Integer> tmpSotheList = newList(tmpSothe);

                if (!checkUnique(stack, tmpSotheList)) {
                    break;
                }

                stack.add(tmpSotheList);
                int count = 0;
                for (int j = 0; j < tmpSothe.length; j++) {
                    if (tmpSnukeList.get(j) > tmpSotheList.get(j)) {
                        count++;
                    }
                }
                maxCount += count;
                map.put(new Integer(maxCount), true);
            }
            if (stack.size() < unknownSum) {
                continue;
            }
            prob.add((double)maxCount / (double)stack.size());
        }

        Collections.sort(prob, Collections.reverseOrder());

        return prob.get(0);
    }

    private ArrayList<Integer> newList(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }


    private boolean checkUnique(ArrayList<ArrayList<Integer>> stack, ArrayList<Integer> item) {
        if (stack.isEmpty()) {
            return true;
        }

        boolean res = true;
        int size = item.size();
        int count = 0;
        for (ArrayList<Integer> n : stack) {

            boolean uniq = false;
            for (int i = 0; i < size; i++) {
                if (item.get(i) != n.get(i)) {
                    uniq = true;
                }
            }
            if (uniq) {
                count++;
            }
        }

        if (count == stack.size()) {
            return true;
        } else {
            return false;
        }

    }



    private static void test(double res, double exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res+"\n");
    }

    public static void main(String[] args) {
        GreaterGame obj = new GreaterGame();
        test(obj.calc(
                    new int[]{4,2},
                    new int[]{-1,-1}), 1.5);
        // Sothe will play the cards 1 and 3 in some unknown order. The best strategy for Snuke is to flip a coin and to play his cards either in the order {2,4} or in the order {4,2} with equal probability. This leads to two equally likely results of the game:
        // Snuke plays his 2 against Sothe's 1, and his 4 against Sothe's 3. In this case, Snuke wins both turns and thus scores 2 points.
        // Snuke plays his 2 against Sothe's 3, and his 4 against Sothe's 1. In this case, Snuke scores 1 point.
        // Therefore, the expected number of Snuke's points is 1.5.

        test(obj.calc(
                    new int[]{4,2},
                    new int[]{1,3}), 2.0);
        //// If Snuke plays card 2 first and card 4 next, he is guaranteed to score 2 points.


        test(obj.calc(
                    new int[]{2},
                    new int[]{-1}), 1.0);
        // Sothe's only card has to be 1, and thus Snuke is guaranteed to win the only turn of this game.

        test(obj.calc(
                    new int[]{1,3,5,7},
                    new int[]{8,-1,4,-1}), 2.5);

        test(obj.calc(
                    new int[]{6,12,17,14,20,8,16,7,2,15},
                    new int[]{-1,-1,4,-1,11,3,13,-1,-1,18}), 8.0);
    }
}
