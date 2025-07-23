public class TreeStatistics {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 計算總和
    public static int sum(TreeNode node) {
        if (node == null) return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    // 2. 找最大值
    public static int findMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    // 2. 找最小值
    public static int findMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);
        return Math.min(node.data, Math.min(leftMin, rightMin));
    }

    // 3. 計算葉節點數量
    public static int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // 4. 計算樹的深度（高度）
    public static int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // 建立範例樹
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(25);

        // 顯示統計資訊
        System.out.println("節點總和: " + sum(root));
        System.out.println("最大值: " + findMax(root));
        System.out.println("最小值: " + findMin(root));
        System.out.println("葉節點數: " + countLeaves(root));
        System.out.println("樹的深度: " + getDepth(root));
    }
}
