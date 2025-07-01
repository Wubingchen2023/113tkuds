public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3,7,3,1,1,1};
        int mode = arr[0]; // 假設第一個為初始眾數
        int maxCount=0; // 目前眾數的出現次數

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int count = 0; // 計算出現次數

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == current) {
                    count++;
                }
            }
            System.out.println("比對中: "+current+"，出現次數: "+count);
            // 更新眾數與最大次數
            if (count > maxCount) {
                mode = current;
                maxCount = count;
            }
        }
        // 輸出結果
        System.out.println("眾數為: " + mode+"，出現 "+maxCount+" 次");
    }
}


/*
時間複雜度為 O(n²)，是否可改善？
可以：使用 HashMap<Integer, Integer> 來記錄每個元素的出現次數，只需一次走訪陣列即可統計出現次數，時間複雜度為 O(n)
 */