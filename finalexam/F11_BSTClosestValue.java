public class F11_BSTClosestValue {
    /*
     * 在 BST 中尋找最接近 target 的節點值；若兩值等距則取較小者
     * @param root BST 根節點
     * @param target 目標值
     * @return 與 target 差距最小的節點值
     */

    static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
        val = x; 
    }
}
    
    public int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            int curVal = node.val;
            // 計算當前節點與 target 的距離
            int curDiff = Math.abs(curVal - target);
            int bestDiff = Math.abs(closest - target);

            // 若更接近，或等距但節點值較小，則更新 closest
            if (curDiff < bestDiff ||
               (curDiff == bestDiff && curVal < closest)) {
                closest = curVal;
            }

            // 根據 BST 性質往左或往右
            if (target < curVal) {
                node = node.left;
            } else if (target > curVal) {
                node = node.right;
            } else {
                
                break; // 完全相等，直接回傳
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        F11_BSTClosestValue solver = new F11_BSTClosestValue();
        int target = 12;
        int result = solver.closestValue(root, target);
        System.out.println("Closest value to " + target + " is: " + result);
    }
}