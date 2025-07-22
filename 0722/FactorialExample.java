public class FactorialExample {
    
    // 原本的遞迴計算階乘
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // 新增：回傳階乘的展開式，例如 "5 * 4 * 3 * 2 * 1 = 120"
    public static String factorialExpansion(int n) {
        // 0! 與 1! 都視為 "1 = 1"
        if (n <= 1) {
            return "1 = 1";
        }
        // 先把展開串起來
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            sb.append(i);
            if (i > 1) {
                sb.append(" * ");
            }
        }
        // 加上 "= 結果"
        sb.append(" = ").append(factorial(n));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("3! = " + factorialExpansion(3));
        System.out.println("5! = " + factorialExpansion(5));
        System.out.println("0! = " + factorialExpansion(0));
    }
}
