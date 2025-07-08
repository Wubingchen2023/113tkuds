public class ArrayStatistics {
    public static void main(String[] args) {
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};
        int sum = 0;
        for (int num: data){
            sum += num;
        }
        double average = (double) sum/data.length;

        int max = data[0];
        int min = data[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i=1; i<data.length; i++){
            if (data[i] > max){
                max = data[i];
                maxIndex = i;
            }
            if (data[i] < min){
                min = data[i];
                minIndex = i;
            }
        }

        int countAboveAvg = 0;
        for (int num: data){
            if (num > average){
                countAboveAvg++;
            }
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int num: data){
            if (num % 2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 以表格形式輸出統計結果
        System.out.println("+----------------------+----------+------------+");
        System.out.printf("| %-20s | %-8s | %-10s |\n", "統計項目", "數值", "索引位置");
        System.out.println("+----------------------+----------+------------+");
        System.out.printf("| %-20s | %8d | %10s |\n", "總和 (Sum)", sum, "-");
        System.out.printf("| %-20s | %8.2f | %10s |\n", "平均值 (Avg)", average, "-");
        System.out.printf("| %-20s | %8d | %10d |\n", "最大值 (Max)", max, maxIndex);
        System.out.printf("| %-20s | %8d | %10d |\n", "最小值 (Min)", min, minIndex);
        System.out.printf("| %-20s | %8d | %10s |\n", "大於平均的個數", countAboveAvg, "-");
        System.out.printf("| %-20s | %8d | %10s |\n", "偶數個數 (Even)", evenCount, "-");
        System.out.printf("| %-20s | %8d | %10s |\n", "奇數個數 (Odd)", oddCount, "-");
        System.out.println("+----------------------+----------+------------+");
    }
}
