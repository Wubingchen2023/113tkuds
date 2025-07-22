public class fibonacci {

    // 遞迴計算第 n 項費波納契數
    public static int FibonacciExample(int n) {
        // 終止條件：第 0 項為 0，第 1 項為 1
        if (n <= 1) {
            return n;
        }
        // 遞迴關係：F(n) = F(n-1) + F(n-2)
        return FibonacciExample(n - 1) + FibonacciExample(n - 2);
    }

    public static void main(String[] args) {
        // 範例：印出前 10 項（0…9）
        for (int i = 0; i < 10; i++) {
            System.out.println("F(" + i + ") = " + FibonacciExample(i));
        }
    }
}
