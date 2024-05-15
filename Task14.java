import java.util.Arrays;

public class Task14 {
    public static void main(String[] arg0){
        int[] array = createAndFill(10, 42);
        System.out.println(Arrays.toString(array));
    }

    public static int[] createAndFill(int len, int initialValue) {
        if (len<0) {
            System.out.println("Отрицательная длина массива! Использовано 0");
            len = 0;
        }
        int[] arr=new int[len];
        for (int i=0; i<len; i++)
            arr[i]=initialValue;
        return arr;
    }
}
