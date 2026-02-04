
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 재귀
// 재귀의 귀재
// https://www.acmicpc.net/problem/25501
public class Baekjoon25501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            sb.append(isPalindrome(str, 0, str.length() - 1, 1));
            sb.append("\n");
        }

        System.out.println(sb);

    }


    public static String isPalindrome(String str, int frontIndex, int rearIndex, int count) {
        
        if (frontIndex >= rearIndex) {
            return 1 + " " + count;
        }
        
        if (str.charAt(frontIndex) != str.charAt(rearIndex)) {
            return 0 + " " + count;
        }

        return isPalindrome(str, ++frontIndex, --rearIndex, ++count);
    }


}
