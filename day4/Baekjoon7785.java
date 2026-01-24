
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

public class Baekjoon7785 {

    public static void main(String[] args) throws IOException{
        /*
4
Baha enter
Askar enter
Baha leave
Artem enter
        
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        TreeSet<String> employees = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < count; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            String enterOrLeave = row[1];

            if ("enter".equals(enterOrLeave)) {
                employees.add(name);
            }

            if ("leave".equals(enterOrLeave)) {
                employees.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String emp : employees) {
            sb.append(emp);
            sb.append("\n");
        }

        System.out.print(sb);
    
    }

    public static void main2(String[] args) throws IOException{
        /*
4
Baha enter
Askar enter
Baha leave
Artem enter
        
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        TreeSet<String> employees = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            String enterOrLeave = row[1];

            if ("enter".equals(enterOrLeave)) {
                employees.add(name);
            }

            if ("leave".equals(enterOrLeave)) {
                employees.remove(name);
            }
        }

        int empCount = employees.size();
    
        for (int i = 0; i < empCount; i++) {
            System.out.println(employees.pollLast());
        }
    
    }
}
