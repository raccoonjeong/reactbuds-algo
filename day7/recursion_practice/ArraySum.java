package recursion_practice;
import java.io.*;
import java.util.*;

public class ArraySum {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = sum(0);
        System.out.print(ans);
    }

    static long sum(int idx) {
        // TODO: base case
        // TODO: return arr[idx] + sum(idx + 1)

        if (idx == (arr.length - 1)) {
            return arr[idx];
        }
        
        return arr[idx] + sum(idx + 1);
    }
}