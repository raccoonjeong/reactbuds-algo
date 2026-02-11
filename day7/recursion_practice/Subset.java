package recursion_practice;

import java.io.*;

public class Subset {
    static int N;
    static boolean[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pick = new boolean[N + 1]; // 1..N
        subset(1);

        System.out.print(sb.toString());
    }

    static void subset(int idx) {
        if (idx == N + 1) {
            printPicked();
            return;
        }

        if (pick[idx]) {
            subset(idx + 1);
        }
        if (!pick[idx]) {
            pick[idx] = true;
            subset(idx + 1);
            pick[idx] = false;
            subset(idx + 1);
        }   
    }

    static void printPicked() {
        boolean first = true;
        for (int i = 1; i <= N; i++) {
            if (pick[i]) {
                if (!first) sb.append(' ');
                sb.append(i);
                first = false;
            }
        }
        sb.append('\n');
    }
}