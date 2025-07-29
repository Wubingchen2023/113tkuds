import java.util.Scanner;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // 讀取換行

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times[i] = toMinutes(time); // 將 HH:mm 轉為分鐘
        }

        String queryTime = sc.nextLine();
        int queryMinutes = toMinutes(queryTime);

        // Binary search: 找到第一個大於 queryMinutes 的時刻
        int left = 0, right = n - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMinutes) {
                resultIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (resultIndex == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(toHHmm(times[resultIndex]));
        }
    }

    // 將 HH:mm → 總分鐘
    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 將分鐘 → HH:mm 格式（補零）
    static String toHHmm(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}

/*
時間複雜度註解：
- 時間轉換與輸入為 O(n)
- 二分搜尋為 O(log n)
總時間複雜度：O(log n)

空間複雜度註解：
- 儲存 n 筆時間的陣列 → O(n)
總空間複雜度：O(n)
*/
