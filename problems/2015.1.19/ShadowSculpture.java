import java.util.*;

public class ShadowSculpture {

    public String possible(String[] XY, String[] YZ, String[] ZX) {

        int N = XY.length + XY[0].length();

        int[][][] coords = new int[N][N][N];


        for (int x = 0; x < XY.length; x++) {
            for (int y = 0; y < XY[0].length(); y++) {

                if (XY[x].charAt(y) == 'Y') {
                    for (int n = 0; n < N; n++) {
                        coords[x][y][n] = 1;
                    }
                }
            }
        }
        for (int y = 0; y < YZ.length; y++) {
            for (int z = 0; z < YZ[0].length(); z++) {

                if (YZ[y].charAt(z) == 'Y') {
                    for (int n = 0; n < N; n++) {
                        coords[n][y][z] = 1;
                    }
                }
            }
        }
        for (int z = 0; z < ZX.length; z++) {
            for (int x = 0; x < ZX[0].length(); x++) {

                if (ZX[z].charAt(x) == 'Y') {
                    for (int n = 0; n < N; n++) {
                        coords[x][n][z] = 1;
                    }
                }
            }
        }


        int edgeX = 0;
        int edgeY = 0;
        int edgeZ = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int z = 0; z < N; z++) {
                    if (coords[x][y][z] == 1) {
                        edgeX = Math.max(edgeX, x);
                        edgeY = Math.max(edgeY, y);
                        edgeZ = Math.max(edgeZ, z);
                        //System.out.println(x+","+y+","+z);
                    }
                }
            }
        }

        System.out.println("X(max):"+edgeX);
        System.out.println("Y(max):"+edgeY);
        System.out.println("Z(max):"+edgeZ);

        ArrayList<Integer> listX = new ArrayList<Integer>();
        ArrayList<Integer> listY = new ArrayList<Integer>();
        ArrayList<Integer> listZ = new ArrayList<Integer>();

        boolean flag = true;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int z = 0; z < N; z++) {
                    if (coords[x][y][z] == 1) {
                        listX.add(x);
                        listY.add(y);
                        listZ.add(z);
                    }
                }
            }
        }

//        listX = uniqItemList(listX);
//        listY = uniqItemList(listY);
//        listZ = uniqItemList(listZ);
//
        System.out.println("X:"+listX);
        System.out.println("Y:"+listY);
        System.out.println("Z:"+listZ);

        return "Possible" ;
    }

    private int validNumber(int[][][] coords, int x, int y, int z) {
        try {
            return coords[x][y][z];

        } catch (Exception e) {
            // I don't care.
        }
        return 0;
    }

    private ArrayList<Integer> uniqItemList(ArrayList<Integer> list) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (Integer i : list) {
            if (!tmp.contains(i)) {
                tmp.add(i);
            }
        }
        return tmp;
    }

    private static void test(String res, String exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res+"\n");
    }

    public static void main(String[] args) {
        ShadowSculpture obj = new ShadowSculpture();

        test(obj.possible(
                    new String[]{"YN","NN"},
                    new String[]{"YN","NN"},
                    new String[]{"YN","NN"}), "Possible");
        // It is possible: we only have one solid cell at (0, 0, 0).

        test(obj.possible(
                    new String[]{"YN","NY"},
                    new String[]{"YN","NY"},
                    new String[]{"YN","NY"}), "Impossible");
        // Here it is impossible to make a valid sculpture. 
        // Note that you can make all three projections look right by using exactly two cubes: 
        // (0,0,0) and (1,1,1). However, this sculpture is not 6-connected.

        test(obj.possible(
                    new String[]{"YYY","YNY","YYY"},
                    new String[]{"YYY","YNY","YYY"},
                    new String[]{"YYY","YNY","YYY"}), "Possible");

        test(obj.possible(
                    new String[]{"YYY","YNY","YYY"},
                    new String[]{"NYY","YNY","YYY"},
                    new String[]{"YYY","YNY","YYN"}), "Impossible");

        test(obj.possible(
                    new String[]{"N"},
                    new String[]{"N"},
                    new String[]{"N"}), "Possible");
        // A sculpture that consists of no cubes is connected.

        test(obj.possible(
                    new String[]{"YNNNY", "NNNNN", "NYNNY", "NNNNN", "YNNYN"},
                    new String[]{"NYNYN", "NYNNN", "NNNNN", "NYNNN", "YNNNY"},
                    new String[]{"YNYNN", "YNYNY", "NNNNN", "NNNNY", "NNYNN"}), "Impossible");

    }

}

