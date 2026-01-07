
import java.util.Scanner;


// 팰린드롬인지 확인하기
// https://www.acmicpc.net/problem/10988
public class Baekjoon10988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        int length = word.length();
        int pivot = length / 2;

        for (int i = 0; i < pivot; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

}
