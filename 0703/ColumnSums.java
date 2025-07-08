import java.util.Scanner;

public class ColumnSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取行數 N 和 列數 M
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 建立陣列並同時準備每列（column）的總和陣列
        int[][] matrix = new int[N][M];
        int[] colSums = new int[M];

        // 讀取矩陣元素，並累加到各列總和
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
                colSums[j] += matrix[i][j];
            }
        }

        // 輸出每一列（column）的總和
        for (int j = 0; j < M; j++) {
            System.out.print(colSums[j]);
            if (j < M - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
