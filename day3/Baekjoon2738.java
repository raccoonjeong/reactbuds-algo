
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// 행렬 덧셈
// https://www.acmicpc.net/problem/2738
public class Baekjoon2738 {
public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] nmArr = new int[N][M];

        for (int i = 0; i < N; i ++) {
            String[] oneRow = br.readLine().split(" ");
            for (int j = 0; j < M; j ++) {
                nmArr[i][j] = Integer.parseInt(oneRow[j]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i ++) {
            String[] oneRow = br.readLine().split(" ");
            for (int j = 0; j < M; j ++) {
                nmArr[i][j] += Integer.parseInt(oneRow[j]);
                bw.write(nmArr[i][j] + " ");
            }

            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
