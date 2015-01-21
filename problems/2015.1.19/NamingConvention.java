import java.util.*;


public class NamingConvention {

    public String toCamelCase(String val) {

        StringBuilder sb = new StringBuilder();

        int len = val.length();
        boolean cap = false;
        for (int i = 0; i+1 < len; i++) {
            if (val.charAt(i) == '_') {
                if (val.charAt(i+1) != '_') {
                    sb.append(Character.toUpperCase(val.charAt(i+1)));
                }
            } else {
                if (val.charAt(i+1) != '_') {
                    sb.append(val.charAt(i+1));
                }
            }
        }
        sb.insert(0, val.charAt(0));

        return sb.toString();
    }

    private static void test(String res, String exp) {
        System.out.println("[EXP]="+exp+"\n[RES]="+res+"\n");
    }

    public static void main(String[] args) {

        NamingConvention obj = new NamingConvention();
        test(obj.toCamelCase(
                    "sum_of_two_numbers"), "sumOfTwoNumbers");
        // We have 4 words: "sum", "of", "two", "numbers". So the answer is "sum" + "Of" + "Two" + "Numbers".

        test(obj.toCamelCase(
                    "variable"), "variable");
        // Note that if we have only 1 word, then the varaible name will remain same.


        test(obj.toCamelCase(
                    "t_o_p_c_o_d_e_r"), "tOPCODER");

        test(obj.toCamelCase(
                    "the_variable_name_can_be_very_long_like_this"), "theVariableNameCanBeVeryLongLikeThis");
    }
}
