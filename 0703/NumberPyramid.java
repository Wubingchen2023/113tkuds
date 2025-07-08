import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取金字塔高度 N
        System.out.print("請輸入金字塔高度 N（1~20）：");
        int N = scanner.nextInt();

        // 外層迴圈：控制行數 1 到 N
        for (int i = 1; i <= N; i++) {
            // 一行總共要印 2*i - 1 個數字
            int length = 2 * i - 1;
            for (int k = 1; k <= length; k++) {
                // 計算第 k 個位置要印的數字
                int val = (k <= i) ? k : (2 * i - k);
                // 列印數字
                System.out.print(val);
                // 在不是最後一個位置時，列印空格
                if (k < length) {
                    System.out.print(" ");
                }
            }
            // 換行到下一行
            System.out.println();
        }

        scanner.close();
    }
}
