import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取站數 n
        int n = sc.nextInt();
        if (n < 1 || n > 131) {
            System.out.println("Invalid");
            return;
        }

        // 讀取 n 個站代碼
        List<String> stops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stops.add(sc.next());
        }

        // 讀取起訖站代碼
        String start = sc.next();
        String end = sc.next();

        // 找出起訖站在停靠表中的索引
        int startIdx = stops.indexOf(start);
        int endIdx = stops.indexOf(end);

        // 檢查任一站不存在
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            // 停靠站數 = |i1 - i2| + 1
            int count = Math.abs(startIdx - endIdx) + 1;
            System.out.println(count);
        }
    }
}

/*
時間複雜度註解：
- 輸入讀取為 O(n)
- 掃描陣列找起訖站為 O(n)
- 最終計算站數為 O(1)
總時間複雜度：O(n)

空間複雜度註解：
- 儲存站碼陣列 stops 為 O(n)
總空間複雜度：O(n)
*/