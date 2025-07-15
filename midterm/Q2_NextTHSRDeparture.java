import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    // 將 HH:mm 時間字串轉換為總分鐘數
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 班次數
        sc.nextLine();         // 換行消耗

        String[] timesStr = new String[n];
        int[] timesMin = new int[n];

        for (int i = 0; i < n; i++) {
            timesStr[i] = sc.nextLine();                // 原始 HH:mm
            timesMin[i] = timeToMinutes(timesStr[i]);   // 換成分鐘數
        }

        String queryStr = sc.nextLine();
        int queryMin = timeToMinutes(queryStr);

        // 二分搜尋找第一個 > query 的班次
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (timesMin[mid] > queryMin) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == n) {
            System.out.println("No train");
        } else {
            System.out.println(timesStr[left]);
        }
    }
}

/*
Time Complexity: O(log n)
說明：使用二分搜尋來查找下一班車的時間，時間複雜度為 O(log n)
*/