import java.util.*;

public class F11_BSTClosestValue {

    // 樹節點定義
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { 
            val = v; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 節點數
        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        int target = sc.nextInt();

        int closest = findClosestValue(root, target);
        System.out.println("Closest: " + closest);
    }

    // 插入 BST（遞迴）
    static TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.val)
            node.left = insert(node.left, val);
        else
            node.right = insert(node.right, val);
        return node;
    }

    // 迴圈方式尋找最接近目標的值（若等距取較小）
    static int findClosestValue(TreeNode node, int target) {
        int closest = node.val;
        while (node != null) {
            int diff = Math.abs(node.val - target);
            int closestDiff = Math.abs(closest - target);

            if (diff < closestDiff || (diff == closestDiff && node.val < closest)) {
                closest = node.val;
            }

            if (target < node.val) {
                node = node.left;
            } else if (target > node.val) {
                node = node.right;
            } else {
                break; // 完全相等時即為最佳解
            }
        }
        return closest;
    }
}
