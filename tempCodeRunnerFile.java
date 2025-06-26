package 0626;

import java.util.Scanner;  // 匯入 Scanner 類別

public class ds_01 {
        // 建立 Scanner 物件，接收使用者輸入
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入第一個整數
        System.out.print("請輸入第一個整數：");
        int num1 = scanner.nextInt();

        // 提示使用者輸入第二個整數
        System.out.print("請輸入第二個整數：");
        int num2 = scanner.nextInt();

        // 計算總和
        int sum = num1 + num2;

        // 顯示結果
        System.out.println("兩數的總和是：" + sum);

        // 關閉 Scanner
        scanner.close();
    }
}
