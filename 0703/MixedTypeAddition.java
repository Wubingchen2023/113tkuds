import java.util.Scanner;

public class MixedTypeAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取整數輸入
        System.out.print("請輸入一個整數：");
        int intNum = sc.nextInt();

        // 讀取浮點數輸入
        System.out.print("請輸入一個浮點數：");
        double doubleNum = sc.nextDouble();

        // 自動型別提升：int + double → double
        double result = intNum + doubleNum;

        // 輸出結果，保留兩位小數
        System.out.println("相加結果為："+result);

        sc.close();
    }
}
