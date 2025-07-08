import java.util.Scanner;

public class FormatFloat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 提示使用者輸入浮點數
        System.out.print("請輸入一個浮點數：");
        double number = sc.nextDouble();

        // 格式化輸出，保留兩位小數
        System.out.printf("格式化後的結果為：%.2f\n", number);

        sc.close();
    }
}
