
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 재귀
// 하노이 탑 이동 순서
// https://www.acmicpc.net/problem/11729
public class Baekjoon11729 {

    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int platesCount = Integer.parseInt(br.readLine());
        // int towersCount = 3;
        StringBuffer sb = new StringBuffer();

        move(platesCount, 1, 2, 3, sb);

        System.out.println(count);
        System.out.print(sb);

    }

    public static void move(int number, int from, int via, int to, StringBuffer sb) {
        // (1) n-1개를 1 -> 2로 옮긴다
        // (2) n번째 원판을 1 -> 3로 옮긴다
        // (3) n-1개를 2 -> 3로 옮긴다
        count += 1;

        if (number == 1) {
            sb.append(from + " " + to).append("\n");
            return;
        }

        move(number - 1, from, to, via, sb) ;
        
        sb.append(from + " " + to).append("\n");

        move(number - 1, via, from, to, sb);


    }
}
