public class ArrayUtility {
    public static void printArray(int[] array){
        System.out.print("[");
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if (i<array.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void reverseArray(int[] array){
        int left = 0;
        int right = array.length-1;
        while (left<right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array){
        int[] copy = new int[array.length];
        for (int i=0; i<array.length; i++){
            copy[i] = array[i];
        }
        return copy;
    }

    public static int findSecendLargest(int[] array){
        if (array.length<2){
            throw new IllegalArgumentException("陣列長度至少為2，才能找到第二大");
        }
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num: array){
            if (num>max){
                second = max;
                max=num;
            } else if (num>second && num<max){
                second = num;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] original = {3, 7, 1, 9, 4, 6, 8, 2, 5};
        System.out.println("原始陣列: ");
        printArray(original);
        
        reverseArray(original);
        System.out.println("\n反轉後的陣列: ");
        printArray(original);
        
        int[] copy = copyArray(original);
        System.out.println("\n複製後的陣列: ");
        printArray(copy);

        reverseArray(original);
        
        int secendLargest = findSecendLargest(original);
        System.out.println("\n原始陣列: ");
        printArray(original);
        System.out.println("\n第二大的值: "+secendLargest);
    }
}
