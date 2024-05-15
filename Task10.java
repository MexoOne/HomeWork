import java.util.Arrays;

public class Task10 {
    public static void main(String[] arg0){
        int[] array = new int[] {0,1,1,0,0,1,2,0,0,0,1,0};
        System.out.println("Before: "+ Arrays.toString(array));
        changeZerosOnes(array);
        System.out.println("After:  "+Arrays.toString(array));
    }

    public static void changeZerosOnes(int[] arr) {
        for (int i=0; i<arr.length; i++)
            switch (arr[i]){
                case 0: {
                    arr[i]=1;
                    break;
                }
                case 1: {
                    arr[i]=0;
                    break;
                }
                default: System.out.println("Внезапно "+arr[i]);
            }
    }
}
