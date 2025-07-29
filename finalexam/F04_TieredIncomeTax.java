import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long totalTax = 0;

        for (int i = 0; i < n; i++) {
            long income = sc.nextLong();
            long tax = calculateTax(income);
            System.out.println("Tax: $" + tax);
            totalTax += tax;
        }

        long avgTax = totalTax / n;
        System.out.println("Average: $" + avgTax);
    }

    // 計算稅額
    static long calculateTax(long income) {
        long tax = 0;

        // 5% for 0 ~ 560,000
        if (income > 0) {
            long slab = Math.min(income, 560000);
            tax += slab * 5 / 100;
        }

        // 12% for 560,001 ~ 1,260,000
        if (income > 560000) {
            long slab = Math.min(income, 1260000) - 560000;
            tax += slab * 12 / 100;
        }

        // 20% for 1,260,001 ~ 2,520,000
        if (income > 1260000) {
            long slab = Math.min(income, 2520000) - 1260000;
            tax += slab * 20 / 100;
        }

        // 30% for 2,520,001 ~ 4,720,000
        if (income > 2520000) {
            long slab = Math.min(income, 4720000) - 2520000;
            tax += slab * 30 / 100;
        }

        // 40% for 4,720,001+
        if (income > 4720000) {
            long slab = income - 4720000;
            tax += slab * 40 / 100;
        }

        return tax;
    }
}

/*
時間複雜度註解：
- 每筆收入計算稅額為 O(1)
- 總共處理 n 筆 → O(n)
總時間複雜度：O(n)

空間複雜度註解：
- 僅使用常數變數 → O(1)
總空間複雜度：O(1)
*/
