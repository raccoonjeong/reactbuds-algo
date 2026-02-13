
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀
// 별 찍기 - 10
// https://www.acmicpc.net/problem/2447
public class Baekjoon2447 {
     public static void main(String[] args) throws IOException {
        // 힌트 얻은 블로그 https://blog.naver.com/PostView.nhn?blogId=ch070414&logNo=222228309897&parentCategoryNo=&categoryNo=21&viewDate=&isShowPopularPosts=false&from=postView
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = (int) (Math.log10(N) / Math.log10(3));

        // N: 3  ->  1,  K: 1
        // N: 9  ->  3,  K: 2
        // N: 27 ->  9,  K: 3
        StringBuilder sb = new StringBuilder();
        // printAll(N, sb, "*");
        int [][] NArr = new int[N][N];

        printEx(N, N, NArr);

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (NArr[i][j] == 0) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

     }
     public static void printEx(int index, int N, int[][] NArr) {
        
        if (index == 1) {
            return;
        }
        // N == 3  -> 1...  index : 0 // 1
        // N == 9  -> 4...  index : 1 // 3,4,5
        // N == 27 -> 13... index : 2 // 11,12,13,14,15

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isTarget(i % index, j % index, index)) {
                    NArr[i][j] = 1;
                }
            }
        }

        printEx(index / 3, N, NArr);

     }

     public static boolean isTarget(int x, int y, int index) {
        // if index = 3
        // (1,1) (4,1) (7,1) ...
        // (1,4) (4,4) (7,4)
        // x-1 -> 3의 배수
        // 1에서 시작
        // 3 / 3 = 1보다 크거나 같고, 2보다 작아야됨

        // if index = 9 ... 총 27 -> 1~9, 9~18, 18~27
        // (3,3) (4,3) (5,3) ... (12,3) (13,3) (14,3) ... (22,3) (23,3) (24,3)
        // 9씩 올라감
        // 4에서 시작
        // 9/3 보다 크거나 같고, 2 * 9/3보다 작아야함
        // 3 * 9/3

        // if index = 27
        // 27 / 3 = 9보다 크거나 같고, 2 * 27 / 3 = 18보다 작아야됨
        // 13에서 시작
        int min = index / 3;
        int max = 2 * index / 3;
        return min <= x && x < max && min <= y && y < max;

     }
  
    
    // public static void printAll(int N, StringBuilder sb, String text) {

    //     printEnd(N / 3, sb, text);
    //     sb.append("\n");

    //     printMiddle(N / 3, sb, text);
    //     sb.append("\n");

    //     printEnd(N / 3, sb, text);
    //     sb.append("\n");
       
    // }

    // public static void printEnd(int N, StringBuilder sb, String text) {
    //     addText(N, sb, text);
    //     addText(N, sb, text);
    //     addText(N, sb, text);
        
    // }

    // public static void printMiddle(int N, StringBuilder sb, String text) {
    //     addText(N, sb, text);
    //     addText(N, sb, " ");
    //     addText(N, sb, text);
    // }

    // public static void addText(int num, StringBuilder sb, String text) {
    //     if (num == 1) {
    //         sb.append(text);
    //         return;
    //     }
    //     printAll(num / 3, sb, text);
    // }

   

    // public static void printFullStars(int start, int N, StringBuilder sb) {
        
    //     printStar(sb);
    //     printStar(sb);
    //     printStar(sb);

    //     sb.append("\n");
    // }

       
    // public static void printRareStars(int start, int N, StringBuilder sb) {
        
    //     printStar(sb);
    //     printEmpty(sb);
    //     printStar(sb);

    //     sb.append("\n");

    // }
    

    // public static void printStar(int num, StringBuilder sb) {
    //     if (num == 1) {
    //         sb.append("*");
    //         return;
    //     }

    //     printAll(num, sb);
    //     // printStar(start + 1, X, sb);
    // }
    // public static void printEmpty(int num, StringBuilder sb) {
    //      if (num == 1) {
    //         sb.append(" ");
    //         return;
    //     }

    //     printAll(num, sb);
    //     // printEmpty(start + 1, X, sb);
    // }


      //  public static void printExe(int start, int N, int K, StringBuilder sb) {
    //     int seq = start / 3; // 0,1,2, 0,1,2 ..
         
    //     sb.append("*").append("*").append("*");
    //     sb.append("\n");
    //     sb.append("*").append(" ").append("*");
    //     sb.append("\n");
    //     sb.append("*").append("*").append("*");
    //     sb.append("\n");
        
    //  }

    // public static void printEx(int start, int N, int K, StringBuilder sb) {

    //     for (int j = 0; j < N / 3; j++) {

    //         for (int i = 0; i < N / 3; i++) {
    //             sb.append("*").append("*").append("*");
    //         }

    //         sb.append("\n");

    //         for (int i = 0; i < N / 3; i++) {
    //             sb.append("*").append(" ").append("*");
    //         }
    //         sb.append("\n");

    //         for (int i = 0; i < N / 3; i++) {
    //             sb.append("*").append("*").append("*");
    //         }
    //         sb.append("\n");
    //     }
    // }


    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     int N = Integer.parseInt(br.readLine());
    
    //     int K = (int) (Math.log10(N) / Math.log10(3));

    //     System.out.println(K);


    //     StringBuilder sb = new StringBuilder();
    //     printStars(0, N, K, sb);
    // }

    // public static void printStars(int start, int N, int K, StringBuilder sb) {

    //     if (start == N / 3) {
    //         System.out.println(sb);
    //         return;
    //     }

    //     // int N = (int) Math.pow(3, K);

    //     printFullStars(start + 1, N, sb);
    //     printRareStars(start + 1, K, sb);
    //     printFullStars(start + 1, N, sb);

        
    //     printStars(start + 1, N, K, sb);
       
    // }

    // public static void printFullStars(int start, int N, StringBuilder sb) {
    //     printStar(0, N, sb);
    //     // printStar(0, N, sb);
    //     // printStar(0, N, sb);
    //     sb.append("\n");
    // }

       
    // public static void printRareStars(int start, int K, StringBuilder sb) {
    //     printStar(0, K, sb);
    //     printEmpty(0, K, sb);
    //     printStar(0, K, sb);
    //     sb.append("\n");
    // }

    // public static void printStar(int start, int X, StringBuilder sb) {
    //     if (start == X) {
    //         return;
    //     }
    //     sb.append("*");
    //     printStar(start + 1, X, sb);
    // }
    // public static void printEmpty(int start, int X, StringBuilder sb) {
    //     if (start == X) {
    //         return;
    //     } 
    //     sb.append(" ");
    //     printEmpty(start + 1, X, sb);
    // }


}
