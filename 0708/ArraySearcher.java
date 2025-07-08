public class ArraySearcher {
    public static int findElement(int[] array, int target){
        for (int i=0; i<array.length; i++){
            if (array[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target){
        int count = 0;
        for (int value: array){
            if (value == target){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] numbers = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};
        int target1 = 67;
        int index1 = findElement(numbers, target1);
        int count1 = countOccurrences(numbers, target1);
        System.out.println("搜尋數字"+target1+": 索引= "+index1+", 出現次數= "+count1);

        int target2 = 100;
        int index2 = findElement(numbers, target2);
        int count2 = countOccurrences(numbers, target2);
        System.out.println("搜尋數字"+target2+": 索引= "+index2+", 出現次數= "+count2);
    }
}
