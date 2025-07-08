import java.util.Scanner;

public class AsciiValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示輸入一個大寫字母
        System.out.print("請輸入一個大寫英文字母：");
        char ch = scanner.next().charAt(0); // 讀取第一個字元

        // 將字元轉為 ASCII 值（整數型別）
        int ascii = (int) ch;

        // 輸出結果
        System.out.println("字元 '" + ch + "' 的 ASCII 碼值為：" + ascii);

        scanner.close();
    }
}
