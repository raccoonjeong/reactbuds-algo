import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 약수 구하기
// https://www.acmicpc.net/problem/2501
public class Baekjoon2501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int count = 0;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count ++;
            }

            if (count == K) {
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}
