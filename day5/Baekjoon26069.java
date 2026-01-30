
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


// 심화2
// 붙임성 좋은 총총이
// https://www.acmicpc.net/problem/26069
public class Baekjoon26069 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(br.readLine());

        // Set<String> justDancers = new HashSet();
        Set<String> rainbowDancers = new HashSet();
        rainbowDancers.add("ChongChong");
        
        for (int i = 0; i < row; i++) {
            String[] dancers = br.readLine().split(" ");

            if (rainbowDancers.contains(dancers[0]) || rainbowDancers.contains(dancers[1])) {
                rainbowDancers.add(dancers[0]);
                rainbowDancers.add(dancers[1]);
            } 
            // else {
            //     justDancers.add(dancers[0]);
            //     justDancers.add(dancers[1]);
            // }

        }

        System.out.println(rainbowDancers.size());


    }
}
