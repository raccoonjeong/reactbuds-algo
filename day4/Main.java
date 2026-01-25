import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] stack = new int[count];
        int cursor = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            int output;
            switch (input) {
                case "2" -> {
                    // 맨 위 정수를 빼고 출력, 없다면 -1 출력
                    if (cursor == 0) {
                        output = -1;
                        break;
                    }
                    cursor --;
                    output = stack[cursor];
                    stack[cursor] = 0;
                }
                case "3" -> {
                    // 정수 개수 출력
                    output = cursor;
                }
                case "4" -> {

                    // 비어있으면 1, 아니면 0 출력
                    if (cursor == 0) {
                        output = 1;
                    } else {
                        output = 0;
                    }
                }
                case "5" -> {
                    // 맨 위의 정수를 그냥 출력, 없다면 -1 출력
                     if (cursor == 0) {
                        output = -1;
                         break;
                    }
                    output = stack[cursor-1];
                }
                default -> {
                    String[] inputs = input.split(" ");
                    if (inputs[0].equals("1")) {
                        // 스택에 넣는다
                        stack[cursor] = Integer.parseInt(inputs[1]);
                        cursor ++;
                    }
                    continue;
                }

            }
            sb.append(output).append("\n");
        }

        System.out.print(sb);
    }


}