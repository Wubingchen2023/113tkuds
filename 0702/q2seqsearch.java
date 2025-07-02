import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 讀取整數n
        int n = sc.nextInt();
        // 宣告陣列
        int[] arr = new int[n];
        // 讀取n個整數
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 讀取key
        int key = sc.nextInt();
        // 線性搜尋
        int ops = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            ops++;
            if (arr[i] == key) {
                found = true;
                break;
            }
        }
        // 輸出結果
        System.out.println("搜尋次數為: " + ops + " 次");
        System.out.println("搜尋結果為: " + (found ? "Yes" : "No"));
        sc.close();
    }
}
