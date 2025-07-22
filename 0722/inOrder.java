// 樹節點類別
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class inOrder {

    // 中序走訪：左 -> 根 -> 右
    public static void InOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left);            // 遞迴左子樹
        System.out.print(root.data + " ");  // 處理根節點
        InOrderTraversal(root.right);           // 遞迴右子樹
    }

    public static void main(String[] args) {
        /*
            測試樹結構：
                1
               / \
              2   3
             / \
            4   5

            中序走訪結果：4 2 5 1 3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("中序走訪結果: ");
        InOrderTraversal(root);
        System.out.println();
    }
}
