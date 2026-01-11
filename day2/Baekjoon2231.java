
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 브루트 포스 - 분해합
// https://www.acmicpc.net/step/22
public class Baekjoon2231 {

    public static void main(String[] args) throws IOException{
        // 분해합 216 -> 생성사 198 ... 가장 작은 생성자 구하기
        // 
        // 211 + 2 + 1 + 1 = 215  
        // 198 + 1 + 9 + 8 = 216
        // 216 - 9 - 9 - 1
        // 512 + 5 + 1 + 2 = 520
        // 가장 작은거 ??? + 9 + 9 + ..

        // 216 ~ 216 - 9 = 207, 108 + 9 = 117
        // 207 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int constructorNum = N / 2; // start

        while(true) {
            if (N == getDisembleSum(constructorNum)) {
                break;
            }
            constructorNum += 1;
            if (N == constructorNum) {
                constructorNum = 0;
                break;
            }
        }

        bw.write(String.valueOf(constructorNum));
        bw.flush();

        br.close();
        bw.close();

    }

    public static int getDisembleSum(int constructorNum) {

        int num = constructorNum;
        int result = num;

        while (true) {
            result += num % 10;
            num = num / 10;
            if (num == 0) {
                break;
            }
        }

        return result;
    }
}