import java.util.Scanner;

public class StringReverse {

    public static String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入一個字串：");
        String input = sc.nextLine();

        String reversed = reverseString(input);
        System.out.println("反轉結果：" + reversed);

        sc.close();
    }
}
