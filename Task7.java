public class Task7 {
    public static void main(String[] arg0){
        boolean res;
        res=isNegative(-1);
        System.out.println(res);
        res=isNegative(1);
        System.out.println(res);
    }

    public static boolean isNegative(int a){
        return a<0;
    }
}
