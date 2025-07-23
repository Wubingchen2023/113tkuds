import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // ✅ 1. 前序 + 中序 → 重建
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + numsLeft,
                               inorder, inStart, inRoot - 1, inMap);
        root.right = buildPreIn(preorder, preStart + numsLeft + 1, preEnd,
                                inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

    // ✅ 2. 後序 + 中序 → 重建
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + numsLeft - 1,
                                inorder, inStart, inRoot - 1, inMap);
        root.right = buildPostIn(postorder, postStart + numsLeft, postEnd - 1,
                                 inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

    // ✅ 工具：建立中序值→索引對照表，加速查找
    private static Map<Integer, Integer> buildIndexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    // ✅ 驗證用：中序走訪
    public static void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderTraversal(node.left, result);
        result.add(node.data);
        inorderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        // 樹的範例如下（中序 = [9,3,15,20,7]）：
        //         3
        //        / \
        //       9  20
        //          / \
        //        15   7

        int[] inorder =  {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // ✅ 前序+中序 → 建立
        TreeNode root1 = buildTreeFromPreIn(preorder, inorder);
        List<Integer> check1 = new ArrayList<>();
        inorderTraversal(root1, check1);
        System.out.println("用 前序+中序 重建後的中序走訪結果：" + check1);

        // ✅ 後序+中序 → 建立
        TreeNode root2 = buildTreeFromPostIn(postorder, inorder);
        List<Integer> check2 = new ArrayList<>();
        inorderTraversal(root2, check2);
        System.out.println("用 後序+中序 重建後的中序走訪結果：" + check2);

        // ✅ 比對與原始中序是否相同
        System.out.println("與原始中序一致？" + Arrays.equals(inorder, check1.stream().mapToInt(i -> i).toArray()));
    }
}
