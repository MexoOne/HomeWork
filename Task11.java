import java.util.Arrays;

public class Task11 {
    public static void main(String[] arg0){
        int[] array = new int[100];
        fillArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
    }
}
