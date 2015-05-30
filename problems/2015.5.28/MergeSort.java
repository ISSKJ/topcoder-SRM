// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
import my.util.*;

public class MergeSort {

    int count = 0;

    public int howManyComparisons(int[] y) {

        count = 0;
        mergeSort(y, 0,  y.length-1);

        return count;
    }

    private void mergeSort(int[] A, int first, int last) {
        if (first < last) {
            int center = (int)Math.floor((first+last)/2);
            mergeSort(A, first, center);
            mergeSort(A, center+1, last);
            merge(A, first, center, last);
        }
    }

    private void merge(int[] A, int first, int center, int last) {
        int n1 = center - first + 1;
        int n2 = last - center;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[first + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = A[center + i + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i, j;
        i = j = 0;
        for (int k = first; k <= last; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();

        TestUtil.test(obj.howManyComparisons(
                    new int[]{1, 2, 3, 4}), 4);
        // {1, 2, 3, 4} is first split to {1, 2} and {3, 4}. {1, 2} is split to {1} and {2} and merging to {1, 2} takes one comparison. {3, 4} is split to {3} and {4} and merging to {3, 4} also takes one comparison. Merging {1, 2} and {3, 4} to {1, 2, 3, 4} takes two comparisons (first 1 is compared to 3 and then 2 is compared to 3). This makes a total of four comparisons.

        TestUtil.test(obj.howManyComparisons(
                    new int[]{2, 3, 2}), 2);
        // {2, 3, 2} is split to {2} and {3, 2}. {3, 2} is split and then merged to {2, 3} making one comparison. {2} and {2, 3} are merged to {2, 2, 3} also making one comparison, which totals to two comparisons made.

        TestUtil.test(obj.howManyComparisons(
                    new int[]{-17}), 0);

        TestUtil.test(obj.howManyComparisons(
                    new int[]{}), 0);

        TestUtil.test(obj.howManyComparisons(
                    new int[]{-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0}), 19);
    }
}
