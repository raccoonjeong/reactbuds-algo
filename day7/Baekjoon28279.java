
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스택, 큐, 덱 1
// 덱 2
// https://www.acmicpc.net/problem/28279
public class Baekjoon28279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        int[] myDeque = new int[N];
        int front = 0;
        int rear = 0;
        int size = 0;

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int command = Integer.parseInt(inputs[0]);

            switch (command) {
                case 1 -> {
                    int x = Integer.parseInt(inputs[1]);
                    
                    if (size > 0) {
                        front --;
                    }
                    front = (front % N + N) % N;
                    myDeque[front] = x;

                    size ++;
                }
                case 2 -> {
                    int x = Integer.parseInt(inputs[1]);
                    
                     if (size > 0) {
                        rear ++;
                    }
                    rear = (rear % N + N) % N;
                    myDeque[rear] = x;

                    size ++;
                }
                case 3 -> {
                    if (size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(myDeque[front]).append("\n");
                    myDeque[front] = 0;
                    front ++;
                    front = (front % N + N) % N;

                    size --;

                    if (size == 0) {
                        front = 0;
                        rear = 0;
                    }
                }
                case 4 -> {
                    if (size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(myDeque[rear]).append("\n");
                    myDeque[rear] = 0;
                    rear --;
                    rear = (rear % N + N) % N;

                    size --;

                    if (size == 0) {
                        front = 0;
                        rear = 0;
                    }
                }
                case 5 -> {
                    sb.append(size).append("\n");
                }
                case 6 -> {
                    if (size == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                }
                case 7 -> {
                    if (size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(myDeque[front]).append("\n");
                }
                case 8 -> {
                    if (size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(myDeque[rear]).append("\n");
                }

            }
            // System.out.println(Arrays.toString(myDeque));
            // System.out.println("front: " + front);
            // System.out.println("rear: " + rear);
            // System.out.println("size: " + size);

        }
        System.out.println(sb);

    }
}
