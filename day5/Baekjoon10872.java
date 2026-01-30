
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 조합론
// 팩토리얼
// https://www.acmicpc.net/problem/10872
public class Baekjoon10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 1;
        for (int i = N; i > 0; i--) {
            result *= i;
        }

        System.out.println(result);

    }
}
