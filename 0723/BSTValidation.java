import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 驗證是否為合法 BST（遞迴上下界法）
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    // 2. 找出不合法的節點（透過中序走訪找降序處）
    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalid = new ArrayList<>();
        findInvalidInOrder(root, new TreeNodeWrapper(), invalid);
        return invalid;
    }

    // 包裝上一個節點（參考型別）
    static class TreeNodeWrapper {
        TreeNode prev = null;
    }

    private static void findInvalidInOrder(TreeNode node, TreeNodeWrapper prevWrapper, List<TreeNode> invalid) {
        if (node == null) return;

        findInvalidInOrder(node.left, prevWrapper, invalid);

        if (prevWrapper.prev != null && node.data <= prevWrapper.prev.data) {
            invalid.add(node);  // 當前節點違反升序性
        }

        prevWrapper.prev = node;
        findInvalidInOrder(node.right, prevWrapper, invalid);
    }

    // 3. 計算需移除多少節點（即違規節點數）
    public static int countInvalidNodes(TreeNode root) {
        return findInvalidNodes(root).size();
    }

    // 範例不合法樹：
    //         10
    //       /    \
    //     5        8   ← 不合法，8 應該 > 10
    public static TreeNode buildInvalidBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); // 錯誤位置
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildInvalidBST();

        System.out.println("是否為有效BST？ " + isValidBST(root));

        System.out.println("\n無效節點:");
        List<TreeNode> badNodes = findInvalidNodes(root);
        if (badNodes.isEmpty()) {
            System.out.println("無");
        } else {
            for (TreeNode node : badNodes) {
                System.out.println("違規節點值: " + node.data);
            }
        }

        System.out.println("\n需移除節點數量: " + countInvalidNodes(root));
    }
}
