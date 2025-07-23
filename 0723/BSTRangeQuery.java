import java.util.ArrayList;

public class BSTRangeQuery {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 在BST中找出範圍[min, max]內的節點值，回傳排序後的ArrayList
    public static void rangeQuery(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        // 左子樹可能有符合範圍的節點
        if (node.data > min) {
            rangeQuery(node.left, min, max, result);
        }

        // 當前節點在範圍內
        if (node.data >= min && node.data <= max) {
            result.add(node.data);
        }

        // 右子樹可能有符合範圍的節點
        if (node.data < max) {
            rangeQuery(node.right, min, max, result);
        }
    }

    // 建立範例BST
    public static TreeNode buildSampleTree() {
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
        TreeNode root = buildSampleTree();

        int min = 12;
        int max = 27;

        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, min, max, result);

        System.out.println("查詢範圍 [" + min + ", " + max + "] 內的節點值:");
        System.out.println(result); // 預期輸出：[15, 20, 25]
    }
}
