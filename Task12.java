import java.util.Arrays;

public class Task12 {
    public static void main(String[] arg0){
        int[] array = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Before: "+ Arrays.toString(array));
        applyMul(array);
        System.out.println("After:  "+Arrays.toString(array));
    }

    public static void applyMul(int[] arr) {
        for (int i=0; i<arr.length; i++)
            if (arr[i]<6)
                arr[i]*=2;
    }
}
