import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 讀取整數n
        int n = sc.nextInt();
        // 宣告陣列與總和變數
        int[] arr = new int[n];
        int sum = 0;
        // 讀取n個整數並計算總和
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        // 輸出總和與加總次數
        System.out.println("總和為: " + sum);
        System.out.println("加總次數為: " + n + " 次");
        sc.close();
    }
}
