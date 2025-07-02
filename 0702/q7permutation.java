import java.util.Scanner;

public class q7permutation {
    static int n; // 排列長度
    static int ops = 0; // 已產生的排列數
    static int[] perm; // 當前排列
    static boolean[] used; // 標示某數字是否已放入

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 讀取排列長度
        perm = new int[n]; // 初始化排列
        used = new boolean[n+1]; // 初始化標示陣列
        backtrack(0); // 開始回溯
        System.out.println(ops); // 輸出已產生的排列數
        sc.close();
    }
    /* backtrack(ops): 在第pos位置放入未使用的數字 */
    private static void backtrack(int pos) {
        if (pos == n) { // 已放滿n個，輸出一個排列
            printPermutation();
            ops++;
            return;
        }
        for (int num = 1; num <= n; num++) {
            if (!used[num]) {
                perm[pos] = num; // 放入當前數字
                used[num] = true; // 標示已使用
                backtrack(pos + 1); // 遞迴放下一格
                used[num] = false; //回溯
            }
        }
    }
    /* printPermutation(): 輸出當前排列 */
    private static void printPermutation() {
        for (int i = 0; i < n; i++) {
            if (i>0){ 
                System.out.print("");
                System.out.println(perm[i]);
            }
            System.out.println();
        }
    }
}
    