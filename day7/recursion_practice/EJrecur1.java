package recursion_practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EJrecur1 {
        static String s;
        static StringBuilder sb = new StringBuilder();

        static int front = 0;
        static int rear = 0;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s = br.readLine();

            reverse(0);
            System.out.print(sb.toString());
        }
        static int reverse(int idx) {
            // TODO: base case
            if(front>=idx) return 0;

            // TODO: recursive call
            // TODO: append char in correct order
            front++;
            return reverse(idx++);
        }
}