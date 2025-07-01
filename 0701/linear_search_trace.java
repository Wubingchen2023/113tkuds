import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        // 固定陣列內容
        int[] s = {1,3,5,7,9};
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字: ");
        int target = sc.nextInt();
        boolean found = false;
        // 執行線性搜尋並印出比對過程
        for (int i = 0; i < s.length; i++) {
            System.out.println("比對中: "+target+" vs "+s[i]);
            if (target == s[i]) {
                found =true;
                break;
            }
        }
        // 印出搜尋結果
        if (found){
            System.out.println("結果:找到");
        } else {
            System.out.println("結果:找不到");
    }
    sc.close();
}
}
