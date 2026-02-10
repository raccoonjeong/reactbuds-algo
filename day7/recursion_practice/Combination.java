package recursion_practice;

import java.io.*;
import java.util.*;

public class Combination {
    static int N, M;
    static int[] out;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        out = new int[M];
        comb(1, 0);

        System.out.print(sb.toString());
    }

    static void comb(int start, int depth) {
        // TODO: if depth == M -> print
        if (depth == M) {
            printOut();
        }

        // TODO: for i from start to N:
        //          out[depth] = i
        //          comb(i + 1, depth + 1)
    }

    static void printOut() {
        for (int i = 0; i < M; i++) {
            sb.append(out[i]).append(i + 1 == M ? '\n' : ' ');
        }
    }
}