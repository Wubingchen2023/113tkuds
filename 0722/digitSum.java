public class digitSum {

    public static int DigitSumExample(int n) {
        // 終止條件：n 為 0 時，總和為 0
        if (n == 0) {
            return 0;
        }
        // 取出最後一位數 + 遞迴處理剩下的數字
        return (n % 10) + DigitSumExample(n / 10);
    }

    public static void main(String[] args) {
        int number = 12345;
        System.out.println("數字 " + number + " 各位數總和為: " + DigitSumExample(number)); // 輸出：15
    }
}
