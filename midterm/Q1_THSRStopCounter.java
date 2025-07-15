import java.util.Scanner;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 讀取站數
        String[] stops = new String[n]; // 儲存停靠站代碼

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next(); // 逐一讀取站名
        }

        String start = sc.next(); // 起點站
        String end = sc.next();   // 終點站

        int startIdx = -1, endIdx = -1;

        // 尋找 start 和 end 的索引
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(startIdx - endIdx) + 1;
            System.out.println(count);
        }
    }
}

/*
Time Complexity: O(n)
說明：需走訪一次 n 個站名來找出起訖位置，n 最多為 12，時間複雜度為 O(n)
*/
