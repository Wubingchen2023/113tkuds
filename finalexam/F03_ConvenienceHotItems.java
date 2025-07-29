import java.util.Scanner;

public class F03_ConvenienceHotItems {
    // 商品資料結構
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // 讀取換行

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);
            items[i] = new Item(name, qty);
        }

        // 插入排序法：由高到低排序
        for (int i = 1; i < n; i++) {
            Item key = items[i];
            int j = i - 1;

            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }

        // 輸出最多前10名
        int top = Math.min(n, 10);
        for (int i = 0; i < top; i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }
    }
}

/*
時間複雜度註解：
- 插入排序最壞情況 O(n^2)
- 輸出前 10 筆為 O(1)
總時間複雜度：O(n^2)

空間複雜度註解：
- 儲存 n 筆商品資料 → O(n)
總空間複雜度：O(n)
*/
