public class array_sum_trace {
    public static void main(String[] args) {
        // 定義固定值的整數陣列
        int[] arr={1,3,5};
        int sum=0;
        // 逐一加總並印出過程
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.println("加入 arr[" + i + "] = " + arr[i] + "，目前的總和為: " + sum);
        }
        // 印出最終總和
        System.out.println("陣列所有元素的總和為: " + sum);
    }
}


/* 
時間複雜度： O(n)
程式透過一次 for 迴圈走訪陣列中的每個元素，進行加總操作與列印輸出，因此時間複雜度為線性階 (n 為陣列長度)。

空間複雜度： O(1)
除了陣列本身和加總變數 sum，沒有使用額外的資料結構，因此為常數空間複雜度。
*/