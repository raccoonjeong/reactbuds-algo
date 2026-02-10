package recursion_practice;
import java.io.*;

public class ReverseString {
    static String s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        reverse(0);

        System.out.println(sb.toString());
    }

    static void reverse(int idx) {

        if (idx == s.length()) {
            return;
        }

        sb.append("" + s.charAt((s.length() - 1) - idx));

        reverse(idx+1);
    }
}