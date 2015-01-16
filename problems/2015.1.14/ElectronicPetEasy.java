import java.util.*;

public class ElectronicPetEasy {

    public String isDifficult(int st1, int cost1, int times1, int st2, int cost2, int times2) {

        int sum;
        ArrayList<Integer> pet1 = new ArrayList<Integer>();
        ArrayList<Integer> pet2 = new ArrayList<Integer>();


        for (int i = st1, count = 0; count < times1; i+=cost1, count++) {
            pet1.add(i);
        }

        for (int i = st2, count = 0; count < times2; i+=cost2, count++) {
            pet2.add(i);
        }

        for (int i : pet1) {
            if (pet2.contains(i)) {
                return "Difficult";
            }
        }
        return "Easy";
    }

    private static void test(String res, String exp) {
        System.out.println(String.format("\n[EXP]=%s\n[RES]=%s\n", exp, res));
    }


    public static void main(String[] args) {
        ElectronicPetEasy obj = new ElectronicPetEasy();
    	
        test(obj.isDifficult(
                    3, 3, 3, 5, 2, 3), "Difficult");
        // Kirino must feed her first pet at the times 3, 6, and 9. 
        // She must feed her second pet at the times 5, 7, and 9. 
        // Feeding these two pets is difficult because she needs to 
        // feed both of them at the same time (at time 9).
    	
        test(obj.isDifficult(
                    3, 3, 3, 5, 2, 2), "Easy");
        // Kirino must feed her first pet at 3, 6, and 9, 
        // and her second pet at 5 and 7. As all of these times are distinct, 
        // feeding these two pets is easy.
    	
        test(obj.isDifficult(
                    1, 4, 7, 1, 4, 7), "Difficult");
    	
        test(obj.isDifficult(
                    1, 1000, 1000, 2, 1000, 1000), "Easy");
    	
        test(obj.isDifficult(
                    1, 1, 1, 2, 2, 2), "Easy");

    }
}
