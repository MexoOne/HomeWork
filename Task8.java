public class Task8 {
    public static void main(String[] arg0){
        repeatString("ABC",3);
        System.out.println("----------");
        repeatString("DEF",0);
        System.out.println("----------");
    }

    public static void repeatString(String s, int n){
        for (int i=0; i<n; i++)
            System.out.println(s);
    }
}
