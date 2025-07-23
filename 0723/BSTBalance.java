public class BSTBalance {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) { this.data = data; }
    }

    // 1. 檢查樹是否為平衡樹（AVL 定義：任一節點左右子樹高度差 ≤ 1）
    //    使用遞迴的「高度或失衡標記」法，O(n) 時間
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 回傳子樹高度；若失衡則回傳 -1 作為標記
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int lh = checkHeight(node.left);
        if (lh == -1) return -1;        // 左子失衡 → 短路
        int rh = checkHeight(node.right);
        if (rh == -1) return -1;        // 右子失衡 → 短路
        if (Math.abs(lh - rh) > 1) return -1;  // 自身失衡
        return Math.max(lh, rh) + 1;    // 沒失衡，回傳高度
    }

    // 2. 計算單一節點的平衡因子：leftHeight - rightHeight
    public static int getBalanceFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    // 簡單遞迴計算高度，O(n)（合併到上面可優化，但此處獨立演示）
    private static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 3. 找出整棵樹中「最不平衡」的節點（絕對平衡因子最大）
    public static TreeNode findMostUnbalanced(TreeNode root) {
        return findUnbalancedHelper(root, new TreeNode[]{null}, new int[]{-1});
    }

    // 遞迴遍歷，每遇一節點計算其 BF，更新最大者
    private static TreeNode findUnbalancedHelper(TreeNode node, TreeNode[] worstNode, int[] worstBF) {
        if (node == null) return worstNode[0];
        int bf = Math.abs(getBalanceFactor(node));
        if (bf > worstBF[0]) {
            worstBF[0] = bf;
            worstNode[0] = node;
        }
        findUnbalancedHelper(node.left, worstNode, worstBF);
        findUnbalancedHelper(node.right, worstNode, worstBF);
        return worstNode[0];
    }

    // 工具：中序遍歷列印所有節點值與其 BF
    public static void printBalanceFactors(TreeNode root) {
        if (root == null) return;
        printBalanceFactors(root.left);
        System.out.printf("節點 %d 的平衡因子 = %d%n",
                          root.data, getBalanceFactor(root));
        printBalanceFactors(root.right);
    }

    // 範例：建一棵略微不平衡的 BST
    //             15
    //           /    \
    //         10      30
    //        /  \       \
    //       5   12       40
    //      /                \
    //     2                  50
    public static TreeNode buildSampleBST() {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.left.left.left = new TreeNode(2);
        root.right.right = new TreeNode(40);
        root.right.right.right = new TreeNode(50);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleBST();

        // 1️⃣ 檢查是否為平衡樹
        System.out.println("BST 是否為平衡樹？ " + isBalanced(root));

        // 2️⃣ 列印每個節點的平衡因子
        System.out.println("\n各節點平衡因子：");
        printBalanceFactors(root);

        // 3️⃣ 找最不平衡的節點
        TreeNode worst = findMostUnbalanced(root);
        System.out.printf("%n最不平衡的節點: %d (|BF| = %d)%n",
                          worst.data, Math.abs(getBalanceFactor(worst)));
    }
}
