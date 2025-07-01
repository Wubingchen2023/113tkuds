import java.util.Scanner;

public class searchnumberbinary {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("請輸入要查找的數字: ");
    int x = sc.nextInt();

    int left = 0;
    int right = s.length-1;
    boolean found = false;

    while(left<=right){
        int mid = (left + right)/2;
        System.out.println("比對中x: "+ x +"，中間元素= "+s[mid]);

        if(s[mid] == x){
            found = true;
            break;
        } else if (s[mid]<x){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    if (found){
        System.out.println("Yes");
    } else {
        System.out.println("No");
    }

    sc.close();
}
}
