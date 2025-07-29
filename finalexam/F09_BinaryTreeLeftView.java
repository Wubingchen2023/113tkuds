import java.util.*;

public class F09_BinaryTreeLeftView {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取層序輸入資料
        String[] input = sc.nextLine().split(" ");
        int[] values = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        TreeNode root = buildTree(values);
        List<Integer> leftView = getLeftView(root);

        System.out.print("LeftView: ");
        for (int val : leftView) {
            System.out.print(val + " ");
        }
    }

    // 根據層序陣列建樹
    static TreeNode buildTree(int[] values) {
        if (values.length == 0 || values[0] == -1) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length && values[i] != -1) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < values.length && values[i] != -1) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 取得左視圖
    static List<Integer> getLeftView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            view.add(queue.peek().val); // 取每層最前面

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return view;
    }
}