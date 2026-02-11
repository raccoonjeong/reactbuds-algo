package recursion_practice;

import java.io.*;
import java.util.*;

public class Permutation {
    static int N, M;
    static int[] out;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        out = new int[M];
        visit = new boolean[N + 1]; // 1..N

        perm(0);

        System.out.print(sb.toString());
    }

    static void perm(int depth) {
        // TODO: if depth == M -> print
        if (depth == M) {
            printOut();
            return;
        }

        // TODO: for i in 1..N:
        //          if visit[i] continue
        //          visit[i] = true
        //          out[depth] = i
        //          perm(depth + 1)
        //          visit[i] = false  // undo
        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }
            // if false
            visit[i] = true;
            out[depth] = i;
            perm(depth + 1);
            visit[i] = false;
        }
    }

    static void printOut() {
        for (int i = 0; i < M; i++) {
            sb.append(out[i]).append(i + 1 == M ? '\n' : ' ');
        }
    }
}