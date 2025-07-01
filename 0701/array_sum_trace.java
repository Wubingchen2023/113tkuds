public class array_sum_trace {
    public static void main(String[] args) {
        int[] numbers={5,10,15,20};
        int sum=0;
        System.out.println("加總過程：");
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            System.out.printf("第 %d 次加總: 目前數字=%d, 加總後總和=%d\n", i + 1, numbers[i], sum);
        }
        System.out.println("最終總和: " + sum);
    }
}
