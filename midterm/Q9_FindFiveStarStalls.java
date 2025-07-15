import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();          // 攤位數
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {  // 讀取評分
            scores[i] = sc.nextInt();
        }

        /* 第一次走訪：統計評分為 5 的數量 */
        int count = 0;
        for (int s : scores) {
            if (s == 5) count++;
        }

        if (count == 0) {
            System.out.println("None");
            return;
        }

        /* 第二次走訪：收集所有索引 */
        int[] idx = new int[count];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                idx[k++] = i;          // 這裡使用 0-based 索引
            }
        }

        /* 輸出索引 */
        for (int i = 0; i < count; i++) {
            System.out.print(idx[i]);
            if (i < count - 1) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}
