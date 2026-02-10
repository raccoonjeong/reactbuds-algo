package recursion_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BKJaGuii02 {

    //2) 배열 합 구하기 (재귀만)
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        //이거뭐임?

        long ans = sum(0); // ans가 뭘까 // sum(0)0번째 인덱스부터 합쳐라
        System.out.print(ans);

    }

    static long sum(int idx){


        return 0L; // 0L뭔지 : long 타입의 정수0
    }

}
