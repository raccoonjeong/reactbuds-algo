
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 백트래킹
// N과 M (1)
// https://www.acmicpc.net/problem/15649
public class Baekjoon15649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        int[] numbers = new int[N]; 
        for (int j = 0; j < N; j++) {
            numbers[j] = j + 1;
        }

        List<Integer> items = new ArrayList<>();
        findNumbers(items, M, numbers);
    }

    public static void findNumbers(List items, int range, int[] numbers) {
        if (items.size() == range) {
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!items.contains(numbers[i])) {
                items.add(numbers[i]);
                findNumbers(items, range, numbers);
                items.remove(items.size() - 1);
            }
        }
        
    }




    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     String[] NM = br.readLine().split(" ");
    //     int N = Integer.valueOf(NM[0]);
    //     int M = Integer.valueOf(NM[1]);


    //     for (int i = 1; i <= N; i++) {
    //         System.out.println(findNumbers(i, 1, M, new StringBuilder()));
    //     }
    // }

    // public static StringBuilder findNumbers(int now, int count, int range, StringBuilder numbers) {
        
    //     numbers.append(now + " ");
        
    //     if (count == range) {
    //         return numbers;
    //     }

    //     return findNumbers(++now, ++count, range, numbers);

    // }
}