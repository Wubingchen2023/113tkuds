import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args) {
        // 建立 Scanner 物件接收輸入
        Scanner sc = new Scanner(System.in);

        // 輸入姓名
        System.out.print("請輸入您的姓名：");
        String name = sc.nextLine();

        // 輸入年齡
        System.out.print("請輸入您的年齡：");
        int age = sc.nextInt();
        sc.nextLine(); // 清除換行字元

        // 輸入城市
        System.out.print("請輸入您所在的城市：");
        String city = sc.nextLine();

        // 輸出結果
        System.out.println("\n以下是您輸入的資訊：");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("城市：" + city);

        // 關閉 Scanner
        sc.close();
    }
}

