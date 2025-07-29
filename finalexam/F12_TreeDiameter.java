public class F12_TreeDiameter {
    // 定義二元樹節點
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int x) { 
            val = x; 
        }
    }

    // 全域變數，用來記錄當前找到的最大直徑（邊數）
    private int diameter = 0;

    // 主函式：傳入根節點，返回直徑（邊數）
    public int treeDiameter(TreeNode root) {
        dfsHeight(root);
        return diameter;
    }

    // 後序遞迴：返回以 node 為根的子樹高度，同時更新 diameter
    private int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 遞迴計算左子樹高度
        int leftH = dfsHeight(node.left);
        // 遞迴計算右子樹高度
        int rightH = dfsHeight(node.right);

        // 經過當前節點的最長路徑邊數 = leftH + rightH
        diameter = Math.max(diameter, leftH + rightH);

        // 回傳子樹高度給上層：包含當前節點 → +1
        return Math.max(leftH, rightH) + 1;
    }

    // 建立測試樹並輸出直徑
    public static void main(String[] args) {
        /*
            範例樹結構：
                  1
                 / \
                2   3
               / \
              4   5
            最長路徑為 4–2–1–3 或 5–2–1–3，邊數皆為 3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        F12_TreeDiameter solver = new F12_TreeDiameter();
        int diam = solver.treeDiameter(root);
        System.out.println("Tree Diameter (edges): " + diam);
    }
}
