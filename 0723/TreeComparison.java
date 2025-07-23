public class TreeComparison {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 判斷兩棵樹是否完全相同
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data &&
               isSameTree(a.left, b.left) &&
               isSameTree(a.right, b.right);
    }

    // 2️⃣ 判斷一棵樹是否為另一棵的子樹
    public static boolean isSubtree(TreeNode main, TreeNode sub) {
        if (main == null) return false;
        if (isSameTree(main, sub)) return true;
        return isSubtree(main.left, sub) || isSubtree(main.right, sub);
    }

    // 3️⃣ 找出兩棵樹的最大公共子樹（回傳其根節點）
    static int maxCommonSize = 0;
    static TreeNode commonSubtreeRoot = null;

    public static int findLargestCommonSubtree(TreeNode a, TreeNode b) {
        maxCommonSize = 0;
        commonSubtreeRoot = null;
        helper(a, b);
        return maxCommonSize; // 傳回大小，可用 commonSubtreeRoot 取得根節點
    }

    private static int helper(TreeNode a, TreeNode b) {
        if (a == null || b == null) return 0;
        if (a.data != b.data) return 0;

        int left = helper(a.left, b.left);
        int right = helper(a.right, b.right);
        int size = 1 + left + right;

        if (size > maxCommonSize) {
            maxCommonSize = size;
            commonSubtreeRoot = a;
        }
        return size;
    }

    // 輔助：中序走訪列印
    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // 測試用樹 A
    public static TreeNode buildTreeA() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    // 測試用樹 B
    public static TreeNode buildTreeB() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        return root;
    }

    // 測試用樹 C
    public static TreeNode buildTreeC() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeA = buildTreeA();  // 大樹
        TreeNode treeB = buildTreeB();  // 子樹
        TreeNode treeC = buildTreeC();  // 不同樹

        // 1. 判斷是否完全相同
        System.out.println("A 和 A 是否相同: " + isSameTree(treeA, treeA));
        System.out.println("A 和 B 是否相同: " + isSameTree(treeA, treeB));

        // 2. 判斷是否為子樹
        System.out.println("\nB 是否為 A 的子樹: " + isSubtree(treeA, treeB));
        System.out.println("C 是否為 A 的子樹: " + isSubtree(treeA, treeC));

        // 3. 找最大公共子樹
        int size = findLargestCommonSubtree(treeA, treeB);
        System.out.println("\nA 與 B 的最大公共子樹大小為: " + size);
        if (commonSubtreeRoot != null) {
            System.out.print("該子樹中序遍歷為: ");
            inorder(commonSubtreeRoot);
            System.out.println();
        }
    }
}
