public class matrix_multiplication_trace {
    public static void main(String[] args) {
        // 定義兩個矩陣
        int[][] a = {
                {1, 2},
                {3, 4},
        };

        int[][] b = {
                {5, 6},
                {7, 8},
        };

        // 初始化結果矩陣
        int[][] c = new int[2][2];

        // 三層迴圈做矩陣乘法
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("計算位置c[" + i + "][" + j + "] : ");
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    int mul=a[i][k] * b[k][j];
                    sum += mul;
                    // 顯示乘法過程
                    System.out.print(a[i][k] + " * " + b[k][j]);
                    if (k < 1) {
                        System.out.print(" + ");
                    } else {
                        System.out.print(" = ");
                    }
                }
                System.out.println(c[i][j] = sum);
            }
        }

        // 顯示結果矩陣
        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}



/*
時間複雜度說明：O(n³)
假設矩陣為 n x n，此程式使用三層巢狀迴圈：

外層兩層（i, j）跑遍所有結果矩陣的 n² 個位置。

內層（k）在每個位置進行 n 次乘法與加總。

因此總運算次數為 n * n * n = n³，所以時間複雜度為 O(n³)。
*/
