// BEGIN CUT HERE

// END CUT HERE
import java.util.*;

public class ChatTranscript {

    public int howMany(String[] transcript, String name) {
        int count = 0;
        for (String s : transcript) {
            if (s.indexOf(name+":") == 0) count++;
        }

        return count;
    }


    public static void test(int exp, int res) {
        System.out.println("[EXP]:"+exp+" \t[RES]:"+res);
    }

    public static void main(String[] args) {
        ChatTranscript obj = new ChatTranscript();
        test(2, obj.howMany(new String[]
                    {
                        "Bob: Hello Tim.",
                            "Tim: Hello Bob.",
                            "Bob: How are ya Tim?",
                            "Frank: Stop chatting!"
                    },
                    "Bob"));
        //Bob managed to say two things before Frank entered the conversation.

        test(1, obj.howMany(new String[]
                    {
                        "Bob: This is a long",
                            "sentence that takes 2 lines.",
                            "Tim: Yes it is.",
                            "Bob : I am not Bob.",
                            "Frank: No you aren't!",
                            " Bob: Neither am I."
                    },
                    "Bob"));
        //Only one line begins with "Bob:" (quotes for clarity).

        test(1, obj.howMany(new String[]
                    {
                        "Crazy1010: !@LK%#L%K @#L%K @#L%K@#L%K2kl53k2",
                            "Bob: You are crazy.",
                            "Crazy1010 Yup #@LK%$L!K%LK%!K% !K afmas,"
                    },
                    "Crazy1010"));

        test(0, obj.howMany(new String[]
                    {
                        "A:A:A:A:A:A:A:A:A",
                            "b:b:b:b:b:b:b:b:b"
                    },
                    "B"));

        test(1, obj.howMany(new String[]
                    {"A:A:A:A:A:A:A:A:A"},
                    "A"));
    }
}
