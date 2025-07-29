import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcdRecursive(a, b);
        long lcm = (long) a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    // 輾轉相減法遞迴求 GCD
    static int gcdRecursive(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcdRecursive(a - b, b);
        else return gcdRecursive(a, b - a);
    }
}

/*
時間複雜度註解：
- 輾轉相減法最壞情況是 O(max(a, b))（每次只減 1）
- 計算 LCM 為 O(1)
總時間複雜度：O(max(a, b))

空間複雜度註解：
- 遞迴呼叫堆疊深度最多為 O(max(a, b))
總空間複雜度：O(max(a, b))
*/
