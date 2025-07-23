import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // 顯示節點資訊 (全形冒號、無多餘空格)
        public void displayNode() {
            System.out.println("節點值：" + data);
            System.out.println("左子節點：" + (left  != null ? left.data  : "null"));
            System.out.println("右子節點：" + (right != null ? right.data : "null"));
        }
    }

    // 層序 (Breadth-First) 列印所有節點
    public static void bfsDisplay(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.displayNode();
            if (node.left  != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    // 旋轉樹狀輸出：先畫右子樹，再印自己，再畫左子樹
    public static void printTree(TreeNode node, int indent) {
        if (node == null) return;
        // 先畫右子樹，深度＋1
        printTree(node.right, indent + 4);
        // 印當前節點
        System.out.print(" ".repeat(indent));
        System.out.println(node.data);
        // 再畫左子樹
        printTree(node.left, indent + 4);
    }

    public static void main(String[] args) {
        // 1) 建樹
        TreeNode root       = new TreeNode(10);
        TreeNode leftChild  = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);
        root.left  = leftChild;
        root.right = rightChild;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        leftChild.left  = node1;
        leftChild.right = node2;

        // 2) 層序顯示所有節點
        bfsDisplay(root);

        // 3) 畫樹狀結構
        System.out.println("\n樹狀結構如下：");
        printTree(root, 0);
    }
}
