public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 全域變數追蹤目前計數與答案
    static int count = 0;
    static int result = -1;

    // 找出BST中第k小的元素
    public static void findKthSmallest(TreeNode node, int k) {
        if (node == null) return;

        // 先走左子樹（小的數）
        findKthSmallest(node.left, k);

        // 中序位置處理當前節點
        count++;
        if (count == k) {
            result = node.data;
            return;
        }

        // 再走右子樹
        findKthSmallest(node.right, k);
    }

    // 呼叫方法，並重置變數
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        findKthSmallest(root, k);
        return result;
    }

    // 建立一棵範例BST
    public static TreeNode buildSampleBST() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleBST();

        // 測試：找第1~7小的元素
        for (int k = 1; k <= 7; k++) {
            int val = kthSmallest(root, k);
            System.out.println("第 " + k + " 小的元素是: " + val);
        }
    }
}
