
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 재귀
// 피보나치 수 5
// https://www.acmicpc.net/problem/10870
public class Baekjoon10870 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getFibonacciNumber(N));

    }

    static int getFibonacciNumber(int N) {
        if (N < 2) {
            return N;
        }

        return getFibonacciNumber(N-1) + getFibonacciNumber(N-2);
    }
}
