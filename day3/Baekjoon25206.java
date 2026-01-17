
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon25206 {
    public static void main(String[] args) throws IOException {
        /**
         * A+	4.5
           A0	4.0
           B+	3.5
           B0	3.0
           C+	2.5
           C0	2.0
           D+	1.5
           D0	1.0
           F	0.0
         */
        //  등급에 따른 과목평점
        Map<String, Double> subjectRatingsByGrade = Map.of("A+", 4.5,
                                                           "A0", 4.0,
                                                           "B+", 3.5,
                                                           "B0", 3.0,
                                                           "C+", 2.5,
                                                           "C0", 2.0,
                                                           "D+", 1.5,
                                                           "D0", 1.0,
                                                           "F", 0.0);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값
        Double totalScore = 0.0;
        Double totalGradeScore = 0.0;
        String subjectScoreGrade;
        while ((subjectScoreGrade = br.readLine()) != null && !subjectScoreGrade.trim().isEmpty()) {
            StringTokenizer st = new StringTokenizer(subjectScoreGrade, " ");
            String subject = st.nextToken();
            Double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }
            Double subjectRating = subjectRatingsByGrade.get(grade);    

            totalScore += score;
            totalGradeScore += score * subjectRating;
        }
        System.out.println(String.format("%.6f", (totalGradeScore / totalScore)));

    }

}
