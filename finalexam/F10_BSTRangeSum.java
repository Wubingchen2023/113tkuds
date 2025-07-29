import java.util.*;

public class F10_BSTRangeSum {

    // BST 節點定義
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { 
            val = v; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 讀入節點數與節點值，建立 BST
        int n = sc.nextInt();
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            root = insert(root, v);
        }

        // 2. 讀入查詢區間 [L, R]
        int L = sc.nextInt();
        int R = sc.nextInt();

        // 3. 計算並輸出區間總和
        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
    }

    // 插入值到 BST
    static TreeNode insert(TreeNode node, int v) {
        if (node == null) return new TreeNode(v);
        if (v < node.val) {
            node.left = insert(node.left, v);
        } else {
            node.right = insert(node.right, v);
        }
        return node;
    }

    // 中序走訪＋剪枝計算區間和
    static int rangeSum(TreeNode node, int L, int R) {
        if (node == null) return 0;
        // 若當前節點值小於 L，則整個左子樹都可剪掉
        if (node.val < L) {
            return rangeSum(node.right, L, R);
        }
        // 若當前節點值大於 R，則整個右子樹都可剪掉
        if (node.val > R) {
            return rangeSum(node.left, L, R);
        }
        // 節點值在 [L,R]，則左右子樹都需繼續訪問
        return node.val
             + rangeSum(node.left, L, R)
             + rangeSum(node.right, L, R);
    }
}