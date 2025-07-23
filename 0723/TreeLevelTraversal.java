import java.util.*;

public class TreeLevelTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 每層節點存在不同的 List 中
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.data);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
        }
        return result;
    }

    // 2. 之字形層序遍歷（zigzag）
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (leftToRight) {
                    level.addLast(curr.data);
                } else {
                    level.addFirst(curr.data);
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // 方向反轉
        }
        return result;
    }

    // 3. 只印每層的最後一個節點
    public static void printLastNodePerLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode lastNode = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                lastNode = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            if (lastNode != null) {
                System.out.println("本層最後節點: " + lastNode.data);
            }
        }
    }

    // 範例樹：
    //         1
    //       /   \
    //      2     3
    //     / \   / \
    //    4   5 6   7

    public static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        System.out.println("1 每層節點分層儲存：");
        List<List<Integer>> levels = levelOrder(root);
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("第 " + (i + 1) + " 層: " + levels.get(i));
        }

        System.out.println("\n2 之字形層序遍歷：");
        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        for (int i = 0; i < zigzag.size(); i++) {
            System.out.println("第 " + (i + 1) + " 層: " + zigzag.get(i));
        }

        System.out.println("\n3 每層最後一個節點：");
        printLastNodePerLevel(root);
    }
}
