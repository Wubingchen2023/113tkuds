public class gcd {

    // 遞迴實作歐幾里德演算法
    public static int GCDexample(int a, int b) {
        if (b == 0) {
            return a;  // 終止條件：b 為 0 時，a 即為最大公因數
        }
        return GCDexample(b, a % b);  // 遞迴：gcd(a, b) = gcd(b, a % b)
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + GCDexample(a, b)); // 輸出：6
    }
}
