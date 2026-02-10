package recursion_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HWReverseString {
    static String s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        reverse(0);

        System.out.print(sb.toString());
    }

    static void reverse(int idx) {
        if(idx == s.length()) { // idx == 0
            return;
        }
        // reverse(idx + 1);
        {
            if(idx == s.length()) { // idx == 1
                return;
            }
            // reverse(idx + 1);
            {
                if(idx == s.length()) { // idx == 2
                    return;
                }
                // reverse(idx + 1);
                {
                    if(idx == s.length()) { // idx == 3
                        return;
                    }
                }
                sb.append(s.charAt(idx));
            }
            sb.append(s.charAt(idx));
        }
        sb.append(s.charAt(idx));
    }

// 0
//   1
//     2
//       3
//         4
//           5 xxx; 리턴
//         4 sb.append(s.charAt(4));
//       3 sb.append(s.charAt(3));
// ...
}