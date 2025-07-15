import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         // 比賽場次
        int[] results = new int[n];   // 勝敗陣列

        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt();  // 1=勝，0=敗
        }

        int k = sc.nextInt();  // 查詢前 k 場

        // 建立 prefix sum 陣列
        int[] prefix = new int[n + 1]; // prefix[0] = 0
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + results[i - 1];
        }

        // 輸出前 k 場的 prefix sum
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + prefix[i]);
        }
        System.out.println();

        sc.close();
    }
}

/*
Time Complexity: O(n)
說明：prefix sum 陣列建表一次 O(n)，前 k 個查詢 O(k)，整體仍為 O(n)
*/
