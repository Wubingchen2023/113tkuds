import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 讀取矩陣大小n
        int n = sc.nextInt();
        // 建立A,B兩個n*n矩陣
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        // 讀取矩陣A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        // 讀取矩陣B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        // 計算矩陣乘積C=A*B，並計算ops=內層(乘法+加法)執行次數
        int[][] C = new int[n][n];
        int ops = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    ops++;
                }
            }
        }
        // 輸出矩陣C(每行n個整數以空格分隔)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        // 輸出總操作次數
        System.out.println(ops);
        sc.close();                 
    }
}

