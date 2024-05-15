public class Task5 {
    public static void main(String[] arg0){
        boolean res;
        res=between10n20(-1,5);
        System.out.println(res);
        res=between10n20(7,9);
        System.out.println(res);
        res=between10n20(21,3);
        System.out.println(res);
    }

    public static boolean between10n20(int a, int b){
        int sum=a+b;
        return sum>=10 && sum<=20; //в пределах от 10 до 20 (включительно)
    }
}
