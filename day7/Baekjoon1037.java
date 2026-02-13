


import java.util.Arrays;
import java.util.Scanner;

// 심화
// 약수 
// https://www.acmicpc.net/problem/1037
public class Baekjoon1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        int[] divisors = new int[count];
        for (int i = 0; i < count; i++) {
            divisors[i] = sc.nextInt();
        }
        
        Arrays.sort(divisors);

        System.out.println(divisors[0] * divisors[count - 1]);
    }
}
