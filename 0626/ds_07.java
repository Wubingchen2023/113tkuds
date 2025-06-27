public class ds_07 {
    public static void main(String[] args) {
        // 建立 3x3 的二維整數陣列，並初始化內容
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 輸出所有元素
        System.out.println("3×3 陣列內容如下：");
        for (int i = 0; i < matrix.length; i++) {             // 外層走列
            for (int j = 0; j < matrix[i].length; j++) {      // 內層走欄
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println(); // 換行
        }
    }
}
