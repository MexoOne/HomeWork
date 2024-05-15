public class Task3 {
    public static void main(String[] arg0){
        printColor();
    }

    public static void printColor(){
        int value=130;
        if (value<=0)
            System.out.println("Красный");
        else if (value<=100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }
}
