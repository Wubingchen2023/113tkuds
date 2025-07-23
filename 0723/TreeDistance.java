import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    // ---------- 1. 計算任意兩節點之間的距離 ----------
    // 1.1 找 LCA（最近共同祖先）
    public static TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // 1.2 從 root 找到某節點值 val 的深度（distance）
    private static int depth(TreeNode root, int val, int d) {
        if (root == null) return -1;
        if (root.data == val) return d;
        int dl = depth(root.left, val, d + 1);
        if (dl != -1) return dl;
        return depth(root.right, val, d + 1);
    }

    // 1.3 任意兩節點距離 = dist(root, n1) + dist(root, n2) - 2*dist(root, LCA)
    public static int distanceBetween(TreeNode root, int n1, int n2) {
        TreeNode lca = findLCA(root, n1, n2);
        int d1 = depth(root, n1, 0);
        int d2 = depth(root, n2, 0);
        int dl = depth(root, lca.data, 0);
        return d1 + d2 - 2 * dl;
    }

    // ---------- 2. 樹的直徑（最大距離） ----------
    // 回傳 Pair(height, diameter)
    static class HD { int height, diameter; }
    private static HD diameterHelper(TreeNode node) {
        if (node == null) return new HD(){ { height = 0; diameter = 0; } };
        HD left = diameterHelper(node.left);
        HD right = diameterHelper(node.right);
        HD curr = new HD();
        // 高度為左右子樹最大高度 +1
        curr.height = Math.max(left.height, right.height) + 1;
        // 直徑為：三者最大值
        // 1) 左子樹直徑 2) 右子樹直徑 3) 通過當前節點的路徑 left.height + right.height
        curr.diameter = Math.max(
            Math.max(left.diameter, right.diameter),
            left.height + right.height
        );
        return curr;
    }
    public static int treeDiameter(TreeNode root) {
        return diameterHelper(root).diameter;
    }

    // ---------- 3. 距離根節點 k 的所有節點 ----------
    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        collectAtDistance(root, k, 0, result);
        return result;
    }
    private static void collectAtDistance(TreeNode node, int k, int depth, List<Integer> res) {
        if (node == null) return;
        if (depth == k) {
            res.add(node.data);
            return;
        }
        collectAtDistance(node.left,  k, depth + 1, res);
        collectAtDistance(node.right, k, depth + 1, res);
    }

    // ---------- 範例樹建構 ------------
    //         1
    //       /   \
    //      2     3
    //     / \   / \
    //    4  5  6   7
    public static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left  = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        // 1. 任意兩點距離
        System.out.println("節點 4 和 5 的距離: " + distanceBetween(root, 4, 5)); // 2
        System.out.println("節點 4 和 6 的距離: " + distanceBetween(root, 4, 6)); // 4

        // 2. 樹的直徑
        System.out.println("\n樹的直徑 (最大距離): " + treeDiameter(root)); // 4 (4→2→1→3→6)

        // 3. 距離根節點 k 的所有節點
        int k = 2;
        List<Integer> atK = nodesAtDistanceK(root, k);
        System.out.println("\n距離根節點 " + k + " 的所有節點: " + atK); // [4,5,6,7]
    }
}
