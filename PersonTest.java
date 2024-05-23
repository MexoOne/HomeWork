//Task 2

public class PersonTest {
    final static int N=5;
    public static void main(String[] args){
        Person[] persArray=new Person[N];
        persArray[0]=new Person("Alekseev Aleksey", "Director", "alalyay@gmail.com",
                "+79991234567", 1000000, 42);
        persArray[1]=new Person("Borisov Boris", "Manager", "borborwhat@yahoo.com",
                "+79999876543", 200000, 29);
        persArray[2]=new Person("Vasilev Vasiliy", "Programmer", "vasvasoops@hotmail.com",
                "+79990001122", 150000, 23);
        persArray[3]=new Person("Grigoriev Grigoriy", "Tester", "grigrihey@post.com",
                "+79991112233", 110000, 25);
        persArray[4]=new Person("Dmitriev Dmitriy", "Designer", "dmitrowow@dot.com",
                "+79994445566", 130000, 27);

        for (int i=0; i<N; i++) {
            System.out.println("#" + (i+1));
            persArray[i].info();
        }
    }
}
