package recursion_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HWArraySum {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 5
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        // 1 2 3 4 5

        long ans = sum(0);
        System.out.print(ans);
    }

    static long sum(int idx) {
        // TODO: base case
        if(idx == n) { // idx == 5
            return 0L;
        }

        // TODO: return arr[idx] + sum(idx + 1)
        return arr[idx] + sum(idx + 1);

//        return 0L;
    }
}