public class Task6 {
    public static void main(String[] arg0){
        checkSignAndPrint(-1);
        checkSignAndPrint(0);
        checkSignAndPrint(1);
    }

    public static void checkSignAndPrint(int a){
        if (a<0)    //Замечание: ноль считаем положительным числом
            System.out.println("Передано отрицательное число");
        else
            System.out.println("Передано положительное число");
    }
}
