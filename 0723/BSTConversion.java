
public class BSTConversion {
    static class TreeNode {
        int data;
        TreeNode left, right;  // 用於樹時：left=左子、right=右子；用於串列時：left=前驅、right=後繼
        public TreeNode(int data) { this.data = data; }
    }

    // ────────────────────────────────────────────────
    // 1. 將 BST 轉換為排序的雙向鏈結串列（不成環）
    //    利用中序走訪，串接前驅(prev)與當前節點；最終 head.left == null, tail.right == null
    static TreeNode listHead = null;
    static TreeNode listPrev = null;
    public static TreeNode bstToDoublyList(TreeNode root) {
        listHead = null;
        listPrev = null;
        convertToList(root);
        return listHead;
    }
    private static void convertToList(TreeNode node) {
        if (node == null) return;
        convertToList(node.left);
        if (listPrev == null) {
            listHead = node;              // 第一次訪問到最小節點，當作 head
        } else {
            listPrev.right = node;        // 前一節點.next = 當前
            node.left = listPrev;         // 當前.prev = 前一節點
        }
        listPrev = node;                  // 更新前驅指標
        convertToList(node.right);
    }

    // ────────────────────────────────────────────────
    // 2. 將排序陣列轉換為平衡的 BST（中序等分法）
    public static TreeNode sortedArrayToBST(int[] arr) {
        return buildBSTFromSorted(arr, 0, arr.length - 1);
    }
    private static TreeNode buildBSTFromSorted(int[] arr, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left  = buildBSTFromSorted(arr, lo, mid - 1);
        root.right = buildBSTFromSorted(arr, mid + 1, hi);
        return root;
    }

    // ────────────────────────────────────────────────
    // 3. 將 BST 每個節點值改為所有大於等於該節點值的節點值總和
    //    利用「反向中序」(右→中→左)，累加一個 runningSum
    static int runningSum = 0;
    public static void convertToGreaterSumTree(TreeNode root) {
        runningSum = 0;
        reverseInorder(root);
    }
    private static void reverseInorder(TreeNode node) {
        if (node == null) return;
        reverseInorder(node.right);
        runningSum += node.data;   // 累積比它大的節點值
        node.data = runningSum;    // 更新為累積和
        reverseInorder(node.left);
    }

    // ────────────────────────────────────────────────
    // 工具：中序走訪列印（樹結構）、印出雙向串列
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void printDoublyList(TreeNode head) {
        TreeNode curr = head;
        System.out.print("DoublyList forward: ");
        while (curr != null) {
            System.out.print(curr.data + (curr.right != null ? " <-> " : ""));
            curr = curr.right;
        }
        System.out.println();
    }

    // 範例樹：              20
    //                     /  \
    //                   10    30
    //                  /  \     \
    //                 5   15     40
    public static TreeNode buildSampleBST() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left  = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.right = new TreeNode(40);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleBST();

        // 1. BST → 雙向串列
        TreeNode listHead = bstToDoublyList(root);
        System.out.println("BST 轉雙向鏈結串列：");
        printDoublyList(listHead);

        // 2. 排序陣列 → 平衡 BST
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstFromArr = sortedArrayToBST(sortedArr);
        System.out.println("\n排序陣列轉平衡 BST，中序走訪：");
        printInorder(bstFromArr);
        System.out.println();

        // 3. BST → Greater Sum Tree
        TreeNode gstRoot = buildSampleBST();  // 重新建立原始
        convertToGreaterSumTree(gstRoot);
        System.out.println("\n轉換為 Greater Sum Tree（中序走訪）：");
        printInorder(gstRoot);
        System.out.println();
    }
}
