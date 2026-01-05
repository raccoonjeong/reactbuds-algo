
import java.util.Scanner;


public class Beakjoon2675 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int count = Integer.parseInt(sc.nextLine());
        String[] inputArray = new String[count];
        for (int i = 0; i < count; i ++) {
            inputArray[i] = sc.nextLine();
        }

        for (int i = 0; i < count; i ++) {
            String[] arr = inputArray[i].split(" ");
            if (arr.length == 0) {
                break;
            }
            int repeat = Integer.valueOf(arr[0]);
            char[] strs = arr[1].toCharArray();

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < strs.length; j++) {
                for(int k = 0; k < repeat; k ++) {
                    sb.append(strs[j]);
                }
            }
            System.out.println(sb.toString());
        }

    }
}