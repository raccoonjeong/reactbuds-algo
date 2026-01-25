
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [약수, 배수와 소수 2] 
// 최소공배수
// https://www.acmicpc.net/problem/1934
public class Baekjoon1934 {

    // https://www.acmicpc.net/source/101871504 요게 잘 짠듯? 근데 성능 비슷한건 풀이가 다 똑같네

    // 수학적으로 최소공배수 구하는 법 찾아보고 만든 방법
    // 유클리드 호제법은 두 수의 최대공약수(GCD)를 구하는 효율적인 알고리즘으로, 큰 수를 작은 수로 나누는 과정을 반복하며 나머지가 0이 될 때까지 진행
    // 최소공배수 = (두 수의 곱) / 최대공약수
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
input:
3
1 45000
6 10
13 17

ouput:
45000
30
221
        */

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            int GCD = getGCD(A,B);

            sb.append(A * B / GCD);
            sb.append("\n");
        }
        System.out.print(sb);

    }

    public static int getGCD(int A, int B) {
        
        if (A < B) {
            int temp;
            temp = A;
            A = B;
            B = temp;
        }

        while (true) {
            int r = A % B;
            if (r == 0) {
                return B;
            }
            A = B;
            B = r;
        }

    }



    // 처음 시도한 방법. A의 배수에 B가 처음으로 나누어 떨어지는 수 구함
    public static void main2(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
input:
3
1 45000
6 10
13 17

ouput:
45000
30
221
        */

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            int fact = 1;
            while (true) {
                int multipleA = A * fact;
                if (multipleA % B == 0) {
                    sb.append(multipleA);
                    sb.append("\n");
                    break;
                } else {
                    fact ++;
                }
            }
        }
        System.out.print(sb);

    }
}
