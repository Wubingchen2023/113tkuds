import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 N
        System.out.print("請輸入矩陣大小 N（1~20）：");
        int N = scanner.nextInt();

        int[][] matrix = new int[N][N];

        int num = 1;             // 當前要填入的數字
        int top = 0, bottom = N - 1;
        int left = 0, right = N - 1;

        // 依序填滿順時針螺旋
        while (top <= bottom && left <= right) {
            // 從左到右 填頂列
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;

            // 從上到下 填右欄
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 從右到左 填底列（若仍有未填列）
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }

            // 從下到上 填左欄（若仍有未填欄）
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        // 輸出矩陣
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
                if (j < N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
