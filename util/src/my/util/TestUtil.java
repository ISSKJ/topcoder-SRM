package my.util;


public final class TestUtil {

    public static void test(String res, String exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }
    public static void test(char res, char exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }
    public static void test(int res, int exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }
    public static void test(long res, long exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }
    public static void test(double res, double exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }
    public static void test(float res, float exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }

    public static void test(String[] res, String[] exp) {
        System.out.print("\n[EXP]=");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]);
            if (i+1 < exp.length) System.out.print(", ");
        }
        System.out.print("\n[RES]=");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i+1 < res.length) System.out.print(", ");
        }
        System.out.println();
    }
    public static void test(char[] res, char[] exp) {
        System.out.print("\n[EXP]=");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]);
            if (i+1 < exp.length) System.out.print(", ");
        }
        System.out.print("\n[RES]=");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i+1 < res.length) System.out.print(", ");
        }
        System.out.println();
    }
    public static void test(int[] res, int[] exp) {
        System.out.print("\n[EXP]=");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]);
            if (i+1 < exp.length) System.out.print(", ");
        }
        System.out.print("\n[RES]=");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i+1 < res.length) System.out.print(", ");
        }
        System.out.println();
    }
    public static void test(long[] res, long[] exp) {
        System.out.print("\n[EXP]=");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]);
            if (i+1 < exp.length) System.out.print(", ");
        }
        System.out.print("\n[RES]=");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i+1 < res.length) System.out.print(", ");
        }
        System.out.println();
    }
    public static void test(double[] res, double[] exp) {
        System.out.print("\n[EXP]=");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]);
            if (i+1 < exp.length) System.out.print(", ");
        }
        System.out.print("\n[RES]=");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i+1 < res.length) System.out.print(", ");
        }
        System.out.println();
    }
    public static void test(float[] res, float[] exp) {
        System.out.print("\n[EXP]=");
        for (int i = 0; i < exp.length; i++) {
            System.out.print(exp[i]);
            if (i+1 < exp.length) System.out.print(", ");
        }
        System.out.print("\n[RES]=");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i+1 < res.length) System.out.print(", ");
        }
        System.out.println();
    }
}
