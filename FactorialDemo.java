//import org.junit.jupiter.api.*;

public class FactorialDemo {
    public static void main(String[] args){
        System.out.println("\tn\tn!");
        for (int n=0; n<10; n++)
            System.out.println("\t"+n+"\t"+factorial(n));
    }

    public static long factorial(int x){
        if (x<0)
            return -1L;
        long y=1;
        for (int i=2; i<=x; i++)
            y*=i;
        return y;
    }
}
