public class isSorted {

    public static boolean ArraySortedCheck(int[] arr, int index) {
        // 終止條件：當 index 到倒數第二個元素時，表示全部檢查過了
        if (index >= arr.length - 1) {
            return true;
        }

        // 若當前元素 > 下一個元素，則不是升序排列
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 遞迴檢查下一對元素
        return ArraySortedCheck(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 7};
        int[] arr2 = {1, 3, 2, 4};

        System.out.println("arr1 是否升序排列: " + ArraySortedCheck(arr1, 0)); // true
        System.out.println("arr2 是否升序排列: " + ArraySortedCheck(arr2, 0)); // false
    }
}
