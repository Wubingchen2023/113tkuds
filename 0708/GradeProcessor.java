public class GradeProcessor {
    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};
        int sum =0;
        for (int score: scores) {
            sum += score;
        }

        double average = (double) sum/scores.length;
        System.out.println("總分: "+sum);
        System.out.printf("平均分數: %.2f%n", average);

        int maxScore = scores[0];
        int minScore = scores[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i=1; i<scores.length; i++){
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
            if (scores[i] < minScore) {
                minScore = scores[i];
                minIndex = i;
            }
        }

        System.out.println("最高分: "+maxScore+" (索引: "+maxIndex+ ")");
        System.out.println("最低分: "+minScore+" (索引: "+minIndex+ ")");

        int countAbove = 0;
        for (int score: scores) {
            if (score>average){
                countAbove++;
            }
        }
        System.out.println("成績平均分數以上的人數: "+countAbove);

        System.out.println("所有成績列表: ");
        for (int i=0; i<scores.length; i++){
            System.out.println("學生編號"+i+": "+scores[i]);
        }
    }
}
