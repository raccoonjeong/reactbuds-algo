
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// [브루트포스] 영화감독 숌
// https://www.acmicpc.net/problem/1436
public class Baekjoon1436 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int series = 0;
        int count = 0;
        while (true) { 
            series += 1;
            String seriesStr = series + "";
            if (seriesStr.contains("666")) {
                count += 1;
                if (N == count) {
                    break;
                }
            }
        }
        System.out.println(series);

        // 참고 문제풀이: https://www.acmicpc.net/source/102105042
        // "자리수 연산을 이용한 브루트포스"
        // "산술 연산 기반 패턴 탐색"
    }
}
