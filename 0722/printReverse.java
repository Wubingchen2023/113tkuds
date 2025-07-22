// 定義鏈結串列節點類別
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class printReverse {

    // 使用遞迴反向列印鏈結串列
    public static void LinkedListReverse(ListNode head) {
        if (head == null) {
            return;
        }
        LinkedListReverse(head.next);       // 先遞迴印出後面的節點
        System.out.print(head.data + " ");  // 再印出當前節點
    }

    public static void main(String[] args) {
        // 建立測試串列：1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("反向列印結果: ");
        LinkedListReverse(head);  // 輸出：4 3 2 1
        System.out.println();
    }
}
