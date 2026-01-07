
// 영수증
// https://www.acmicpc.net/problem/25304

import java.util.Scanner;

public class Baekjoon25304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalPrice = Integer.parseInt(sc.nextLine());
        int totalCount = Integer.parseInt(sc.nextLine());

        int realTotalPrice = 0;
        for (int i = 0; i < totalCount; i++) {
            String[] input = sc.nextLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);

            realTotalPrice += (price * count);
        }

        if (totalPrice == realTotalPrice) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}