import java.util.Scanner;
public class ds_02 {
    public static void main(String[] args) {
        // 建立 Scanner 物件，接收輸入
        Scanner sc = new Scanner(System.in);

        // 提示使用者輸入半徑
        System.out.print("請輸入圓的半徑：");
        double radius = sc.nextDouble();

        // 計算圓面積：面積 = π * r * r
        double area = Math.PI * radius * radius;

        // 輸出結果
        System.out.println("圓的面積為：" + area);

        // 關閉 Scanner
        sc.close();
    }
}

