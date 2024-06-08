//Task 1, Dog class

public class Dog extends Animal{
    private static int dogsCount=0;

    final static int runDistance=500;
    final static int swimDistance=10;

    public Dog(String _name){
        super(_name);
        dogsCount++;
    }

    @Override
    public void run(int distance){
        if (distance >= 0 && distance <= runDistance)
            System.out.println("Собака " + getName() + " пробежала " + distance + " метров.");
        else
            System.out.println("Собака " + getName() + " не может пробежать " + distance + " метров.");
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0 && distance <= swimDistance)
            System.out.println("Собака " + getName() + " проплыла " + distance + " метров.");
        else
            System.out.println("Собака " + getName() + " не может проплыть " + distance + " метров.");
    }

    public static int getDogsCount(){
        return dogsCount;
    }
}
