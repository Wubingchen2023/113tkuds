import java.util.Scanner;

public class Q4_TieredElectricBill {

    // 計算單一用電量的電費（NT$）
    public static double calc(int kWh) {
        double bill = 0;
        int remaining = kWh;

        // 每段階梯：上限（kWh）與單價（NT$）
        int[] limits   = {120, 210, 170, 200, 300};         // 各階梯的寬度：120, (330−120)=210, (500−330)=170, …
        double[] price = {1.68, 2.45,   3.70,   5.04,   6.24};

        // 第一五段累計
        for (int i = 0; i < limits.length && remaining > 0; i++) {
            int used = Math.min(remaining, limits[i]);
            bill += used * price[i];
            remaining -= used;
        }
        // 第六段（>1000 kWh）
        if (remaining > 0) {
            bill += remaining * 8.46;
        }
        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long totalRounded = 0;

        int[] usages = new int[n];
        for (int i = 0; i < n; i++) {
            usages[i] = sc.nextInt();
        }

        // 計算並列印每月帳單
        for (int kWh : usages) {
            double raw = calc(kWh);
            long rounded = Math.round(raw);           // 四捨五入至整數
            System.out.println("Bill: $" + rounded);
            totalRounded += rounded;
        }

        // 列印總電費與平均電費（四捨五入至整數）
        System.out.println("Total: $" + totalRounded);
        long avgRounded = Math.round((double) totalRounded / n);
        System.out.println("Average: $" + avgRounded);

        sc.close();
    }
}

/*
Time Complexity: O(n)
說明：對每個用電量只做固定階梯計算，整體隨輸入筆數 n 線性增長，故時間複雜度為 O(n)。
*/
