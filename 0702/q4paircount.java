import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 讀取整數n
        int n = sc.nextInt();
        // 宣告陣列
        int[] arr = new int[n];
        // 讀取n個整數(實際不參與計算)
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int pairCount = 0;
        int ops = 0;
        // 使用雙重迴圈列出所有成對索引組合
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairCount++;
                ops++;
            }
        }
        // 輸出結果
        System.out.println("計算次數為: " + ops + " 次");
        System.out.println("成對索引組合數量: " + pairCount);
        sc.close();
    }
}
