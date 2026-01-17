
// 진법
// https://www.acmicpc.net/problem/2745

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2745 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        // ascii 0 to 9 ~ 48 to 57
        // ascii A to Z ~ 65 to 90
        String B = inputs[0]; // ZZZZZ, 10101, Z1
        Integer N = Integer.parseInt(inputs[1]);


        int decimalNumber = 0;
        for (int i = 0; i < B.length(); i ++) {
            char characterB = B.charAt(i);
            int integerB = (int) characterB;
            int eachNumber;
            if (integerB >= 65) {
                eachNumber = integerB - 65 + 10;
            } else {
                eachNumber = integerB - 48;
            }

            decimalNumber += eachNumber * Math.pow(N, B.length() - 1 - i);
        }

        System.out.println(decimalNumber);
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String[] inputs = br.readLine().split(" ");
        // // ascii 0 to 9 ~ 48 to 57
        // // ascii A to Z ~ 65 to 90
        // String B = inputs[0]; // ZZZZZ, 10101, Z1
        // Integer N = Integer.parseInt(inputs[1]);

        // int[] resultArr = new int[B.length()];

        // for (int i = 0; i < B.length(); i ++) {
        //     char characterB = B.charAt(i);
        //     int integerB = (int) characterB;
            
        //     if (integerB >= 65) {
        //         resultArr[i] = integerB - 65 + 10;
        //     } else {
        //         resultArr[i] = integerB - 48;
        //     }
        // }

        // int decimalNumber = 0;

        // for (int i = 0; i < resultArr.length; i ++) {
        //     decimalNumber += resultArr[i] * Math.pow(N, resultArr.length - 1 - i);
        // }

        // System.out.println(decimalNumber);

        // 이산수학 참고 블로그: https://m.blog.naver.com/noksek0615/223141412248
    }
}
