import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    // ✅ 1. 找出從根到所有葉節點的路徑
    public static void findAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == null) return;

        path.add(node.data);  // 加入當前節點

        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(path));  // 是葉節點 → 儲存路徑
        } else {
            findAllPaths(node.left, path, allPaths);
            findAllPaths(node.right, path, allPaths);
        }

        path.remove(path.size() - 1);  // 回溯
    }

    // ✅ 2. 判斷是否存在某和的根到葉路徑
    public static boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;

        // 葉節點，判斷剩餘 sum 是否為 0
        if (node.left == null && node.right == null) {
            return node.data == targetSum;
        }

        int newTarget = targetSum - node.data;

        return hasPathSum(node.left, newTarget) || hasPathSum(node.right, newTarget);
    }

    // ✅ 3. 找出和最大的根到葉路徑
    public static void findMaxSumPath(TreeNode node, List<Integer> path, List<Integer> maxPath, int currentSum, int[] maxSum) {
        if (node == null) return;

        path.add(node.data);
        currentSum += node.data;

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(path);
            }
        } else {
            findMaxSumPath(node.left, path, maxPath, currentSum, maxSum);
            findMaxSumPath(node.right, path, maxPath, currentSum, maxSum);
        }

        path.remove(path.size() - 1);  // 回溯
    }

    // 建立一棵測試用的BST：
    //         10
    //       /    \
    //      5      20
    //     / \    /  \
    //    3   7  15  25
    public static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        // ✅ 1. 所有根到葉路徑
        List<List<Integer>> allPaths = new ArrayList<>();
        findAllPaths(root, new ArrayList<>(), allPaths);
        System.out.println("所有根到葉路徑：");
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }

        // ✅ 2. 是否存在和為 target 的路徑
        int target = 28;
        System.out.println("\n是否存在總和為 " + target + " 的路徑？" + hasPathSum(root, target));

        // ✅ 3. 最大總和的根到葉路徑
        List<Integer> maxPath = new ArrayList<>();
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        findMaxSumPath(root, new ArrayList<>(), maxPath, 0, maxSum);

        System.out.println("\n最大總和路徑為: " + maxPath);
        System.out.println("最大總和為: " + maxSum[0]);
    }
}
