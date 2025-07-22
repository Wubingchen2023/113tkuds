public class fibonacciSlow {

// 標準遞迴版本 - 效率很差
    public static int fibonaccislow(int n) {
        if (n <= 1) return n;
        return fibonaccislow(n - 1) + fibonaccislow(n - 2);
    }
// 時間複雜度：O(2^n) - 指數級成長！
// 空間複雜度：O(n) - 遞迴深度

// 記憶化版本 - 效率很好
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
// 時間複雜度：O(n) - 每個數字只計算一次
// 空間複雜度：O(n) - 儲存計算結果
    public static void main(String[] args) {
        int n = 40;  // 可調整 n 大小做測試（建議 n ≤ 40）

        // 測試 slow 版本
        long start1 = System.currentTimeMillis();
        int result1 = fibonaccislow(n);
        long end1 = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + result1 + "，耗時: " + (end1 - start1) + " ms");

        // 測試 fast 版本
        int[] memo = new int[n + 1]; // 自動初始化為0
        long start2 = System.currentTimeMillis();
        int result2 = fibonacciFast(n, memo);
        long end2 = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + result2 + "，耗時: " + (end2 - start2) + " ms");
    }
}

