
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 알파벳
// https://www.acmicpc.net/problem/10809
public class Baekjoon10809 {
    public static void main(String[] args) throws IOException{
      // in: baekjoon
      // out: 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 97; i <= 122; i ++) {
            sb.append(word.indexOf((char) i) + " ");
        }

        System.out.println(sb.toString());


    //   Scanner sc = new Scanner(System.in);
    //   String word = sc.nextLine();
    //   String alphabet = "abcdefghijklmnopqrstuvwxyz";
    //   StringBuffer sb = new StringBuffer();
    //   for (int i = 0; i < alphabet.length(); i ++) {
    //     sb.append(word.indexOf(alphabet.charAt(i)) + " ");
    //   }

    //   System.out.println(sb.toString());

    }
}
