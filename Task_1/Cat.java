//Task 1, Cat class

public class Cat extends Animal{
    private static int catsCount=0;

    final static int runDistance=200;

    public Cat(String _name){
        super(_name);
        catsCount++;
    }

    @Override
    public void run(int distance){
        if (distance >= 0 && distance <= runDistance)
            System.out.println("Кот " + getName() + " пробежал " + distance + " метров.");
        else
            System.out.println("Кот " + getName() + " не может пробежать " + distance + " метров.");
    }

    @Override
    public void swim(int distance){
        System.out.println("Коты не плавают!");
    }

    public static int getCatsCount(){
        return catsCount;
    }
}
