import java.util.*;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 建立地圖，初始化為 #
        char[][] map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(map[i], '#');
        }

        // 讀取 m 筆座標資料
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            // 若座標在範圍內，標記為 *
            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                map[r][c] = '*';
            }
        }

        // 列印地圖
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(); // 換行
        }
        sc.close();
    }
}