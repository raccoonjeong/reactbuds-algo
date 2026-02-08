

// 백트래킹
// N과 M (2)
// https://www.acmicpc.net/problem/15650

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon15650 {

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
        findNumbers(0, items, M, numbers);
    }

    public static void findNumbers(int start, List items, int range, int[] numbers) {
        if (items.size() == range) {
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            items.add(numbers[i]);
            findNumbers(i + 1, items, range, numbers);
            items.remove(items.size() - 1);
        }
        
    }

    // public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	// static boolean[] visit;
	// static int[] arr;
	
	// public static void main(String[] args) throws IOException{
		
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	// 	String[] NM = br.readLine().split(" ");
		
	// 	int N = Integer.parseInt(NM[0]);
	// 	int M = Integer.parseInt(NM[1]);
		
	// 	visit = new boolean[N];
	// 	arr = new int[M];
		
	// 	dfs(0, N, M,0);
	
	// 	bw.flush();
	// 	bw.close();
	
	// }
	
	// public static void dfs(int start, int N, int M, int depth) throws IOException{
		
	// 	if (depth == M) {
	// 		for (int val : arr) {
	// 			bw.write(String.valueOf(val)+" ");
	// 		}
	// 		bw.write("\n");
	// 		return;
	// 	}
		
	// 	for (int i = start; i < N; i++) {
    //         arr[depth] = i + 1;
    //         dfs(i + 1, N, M, depth + 1);
				
	// 	}
		
		
	// }
}
