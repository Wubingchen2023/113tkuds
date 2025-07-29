import java.util.Scanner;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int mask = 0;

        for (char c : line.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int bit = c - 'a';
                mask ^= (1 << bit);  // 切換第 bit 位元（出現奇數次就為 1）
            }
        }

        // 只要 mask 中最多只有一個位元為 1，則可構成回文
        if (mask == 0 || (mask & (mask - 1)) == 0) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}