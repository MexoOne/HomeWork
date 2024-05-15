public class Task2 {
    public static void main(String[] arg0){
        checkSumSign();
    }

    public static void checkSumSign(){
        int a=3;
        int b=-7;
        int sum=a+b;
        if (sum>=0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }
}
