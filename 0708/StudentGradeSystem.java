public class StudentGradeSystem {
    public static char gradeFromScore(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else {
            return 'D';
        }
    }

    public static void printReport(int[] scores) {
        int n = scores.length;
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        int maxIndex = 0;
        int minIndex = 0;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;

        for (int i = 0; i < n; i++) {
            int s = scores[i];
            sum += s;

            if (s > max) {
                max = s;
                maxIndex = i;
            }
            if (s < min) {
                min = s;
                minIndex = i;
            }

            // ✅ Count grades properly here
            char grade = gradeFromScore(s);
            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }
        }

        double average = (double) sum / n;
        int aboveCount = 0;

        for (int s : scores) {
            if (s > average) {
                aboveCount++;
            }
        }

        double aboveRatio = (double) aboveCount / n * 100;

        // 🖨 Output
        System.out.println("====== 學生成績報告 ======");
        System.out.println("全班人數: " + n + "    平均分: " + String.format("%.2f", average));
        System.out.println("----------------------------------------");
        System.out.println("等級統計:");
        System.out.println("A: " + countA + " 人    B: " + countB + " 人    C: " + countC + " 人    D: " + countD + " 人");
        System.out.println("最高分: " + max + " (學生編號 " + maxIndex + ")    最低分: " + min + " (學生編號 " + minIndex + ")");
        System.out.println("高於平均分人數: " + aboveCount + " 人 (" + String.format("%.1f", aboveRatio) + "%)");
        System.out.println("----------------------------------------");
        System.out.println("詳細名單:");
        System.out.printf("%-8s %-6s %-4s\n", "學號", "分數", "等級");
        System.out.println("----------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-6d %-4c\n", i, scores[i], gradeFromScore(scores[i]));
        }
        System.out.println("====== 報告完畢 ======");
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        printReport(scores);
    }
}
