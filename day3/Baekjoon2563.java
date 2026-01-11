import java.util.Scanner;

// 색종이
// https://www.acmicpc.net/problem/2563
public class Baekjoon2563 {

    public static void main(String[] args) {
        // input
        // 3
        // ## 1 2 (길이는 5)
        // 3 7
        // 15 7
        // 5 2
        // output
        // 260

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int [][] coordinate = new int [100][100];

        for (int k = 0; k < count; k++) {
            String[] arr = sc.nextLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    coordinate[i][j] += 1;
                }
            }
        }

        int extent = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (coordinate[i][j] > 0) {
                    extent += 1;
                }
            }
        }

        System.out.println(extent);
    }
}