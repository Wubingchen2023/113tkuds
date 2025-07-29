import java.util.Scanner;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n ≥ 2
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Pair result = findSecondLargest(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    // 自定義 Pair 結構儲存最大值與次大值
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // 遞迴找最大與次大值
    static Pair findSecondLargest(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE); // 單元素
        }

        int mid = (left + right) / 2;
        Pair p1 = findSecondLargest(arr, left, mid);
        Pair p2 = findSecondLargest(arr, mid + 1, right);

        // 合併兩邊
        int max, second;
        if (p1.first > p2.first) {
            max = p1.first;
            second = Math.max(p1.second, p2.first);
        } else {
            max = p2.first;
            second = Math.max(p2.second, p1.first);
        }

        return new Pair(max, second);
    }
}

/*
時間複雜度註解：
- 每層分治為 O(1)，共 log n 層，每層合併 O(1)
- 遞迴共 O(n) 次基本操作
總時間複雜度：O(n)

空間複雜度註解：
- 遞迴堆疊最深為 O(log n)
總空間複雜度：O(log n)
*/
