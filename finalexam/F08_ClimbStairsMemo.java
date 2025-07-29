import java.util.*;

public class F08_ClimbStairsMemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 樓梯階數 n ≤ 40

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // 初始化為未計算狀態

        int ways = countWays(n, memo);
        System.out.println("Ways: " + ways);
    }

    // 計算 f(n) = f(n-1) + f(n-2) + f(n-3) 
    static int countWays(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (memo[n] != -1) return memo[n];

        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        return memo[n];
    }
}
