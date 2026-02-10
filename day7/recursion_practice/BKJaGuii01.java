package recursion_practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BKJaGuii01 {
    //1) 문자열 뒤집기 (재귀만)
    static String s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        s= br.readLine();
        reverse(0);

        System.out.print(sb.toString());
    }

    static void reverse(int idx){
//        if(s의 글자길이가 1인경우)그대로 나옴
        if(s.length()==1) return;
//            그렇지 않은경우 뒤집은 문자열을 출력?

//        sb.append();

    }

}
