import java.util.Scanner;

// 1998년생인 내가 태국에서는 2541년생?!
// https://www.acmicpc.net/problem/18108
public class Baekjoon18108 {

    public static void main(String[] args) {
        // 2541, 1998
        // Buddhist year, Christian year
        Scanner sc = new Scanner(System.in);
        int diff = 2541 - 1998;
        int buddhistYear = Integer.valueOf(sc.nextLine());
        System.out.println(buddhistYear - diff);

    }
}
