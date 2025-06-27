public class ds_05 {
    public static void main(String[] args) {
        // 建立一個含有 10 個整數的陣列
        int[] numbers = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

        // 宣告變數來儲存總和
        int sum = 0;

        // 使用 for 迴圈計算總和
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // 將每個元素加到總和中
        }

        // 輸出結果
        System.out.println("陣列中所有元素的總和是：" + sum);
    }
}

