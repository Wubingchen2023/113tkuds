import java.util.Scanner;

public class FactorialExampleinput {

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static String buildFactorialSteps(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0 || n == 1) {
            sb.append("1");
        } else {
            for (int i = n; i >= 1; i--) {
                sb.append(i);
                if (i != 1) {
                    sb.append(" * ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入一個非負整數: ");
        int n = sc.nextInt();

        String steps = buildFactorialSteps(n);
        long result = factorial(n);

        System.out.println(n + "! = " + steps + " = " + result);

        sc.close();
    }
}
