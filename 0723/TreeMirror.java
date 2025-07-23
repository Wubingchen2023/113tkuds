public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 判斷一棵樹是否對稱（即左右子樹互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return areMirrors(root.left, root.right);
    }

    // 2. 將一棵樹轉為鏡像樹（原地修改）
    public static void mirror(TreeNode node) {
        if (node == null) return;

        // 先鏡像左右子樹
        mirror(node.left);
        mirror(node.right);

        // 然後交換左右節點
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // 3. 判斷兩棵樹是否互為鏡像
    public static boolean areMirrors(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.data == b.data)
            && areMirrors(a.left, b.right)
            && areMirrors(a.right, b.left);
    }

    // 中序遍歷（顯示用）
    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // 建立一棵對稱的樹
    public static TreeNode buildSymmetricTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }

    public static void main(String[] args) {
        // 測試 1：判斷是否為對稱樹
        TreeNode root = buildSymmetricTree();
        System.out.println("是否為對稱樹？" + isSymmetric(root));  // true

        // 測試 2：鏡像轉換
        System.out.print("中序遍歷原樹: ");
        inorder(root);
        System.out.println();

        mirror(root);  // 鏡像
        System.out.print("中序遍歷鏡像後: ");
        inorder(root);
        System.out.println();

        // 測試 3：比較兩棵樹是否互為鏡像
        TreeNode treeA = buildSymmetricTree();
        TreeNode treeB = buildSymmetricTree();
        mirror(treeB);
        System.out.println("treeA 和 treeB 是否互為鏡像？" + areMirrors(treeA, treeB));  // true
    }
}
