import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] station = new String[n];
        int[][] price = new int[n][2];  // [i][0] = Standard, [i][1] = Business

        for (int i = 0; i < n; i++) {
            station[i] = sc.next();        // 站名
            price[i][0] = sc.nextInt();    // Standard
            price[i][1] = sc.nextInt();    // Business
        }

        // 表頭
        System.out.println("Station|Standard|Business");

        // 每行輸出
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", station[i], price[i][0], price[i][1]);
        }

        sc.close();
    }
}
