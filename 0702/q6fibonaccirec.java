import java.util.Scanner;

public class q6fibonaccirec {
    static long ops = 0; // 用於計算遞迴呼叫次數

    private static long fib(int n) {
        ops++; // 每次遞迴呼叫時ops加1
        if (n <= 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = fib(n); // 呼叫遞迴函數計算F(n)
        System.out.println(result); // 輸出F(n)
        System.out.println(ops); // 輸出遞迴呼叫次數
        sc.close();
    }
}
