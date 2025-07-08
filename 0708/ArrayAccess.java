public class ArrayAccess {
    public static void main(String[] args) {
        int[] scores = {85, 92, 77, 60, 88};
        int firstScore = scores[0];
        int lastScore = scores[4];
        int middleScore = scores[2];
        System.out.println("第一個成績: "+firstScore);
        System.out.println("最後一個成績: "+lastScore);
        System.out.println("中間成績: "+middleScore);
        // 修改操作_直接更新指定位置的值
        scores[0]=90; //將第一個成績改成90
        scores[scores.length-1] = 95; //將最後一個成績改成95
        // 取得陣列屬性資訊
        int arrayLength = scores.length; // 陣列長度:5
        System.out.println("\n修改後的陣列: ");
        for(int i=0; i<arrayLength; i++){
            System.out.printf("索引 %d:%d\n", i, scores[i]);
        }
    }
}
