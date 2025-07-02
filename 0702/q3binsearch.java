import java.util.Scanner;

public class q3binsearch {
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
        // 二元搜尋
        int ops = 0;
        int left = 0, right = n - 1;
        int mid;
        int index = -1;
        while (left <= right) {
            ops++;
            mid = (left + right) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 輸出結果
        System.out.println("搜尋次數為: " + ops + " 次");
        System.out.println("索引位置: " + index);
        sc.close();
    }
}
