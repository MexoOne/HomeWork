//Task 1, basic abstract class Animal

public abstract class Animal {
    private static int animalsCount=0;
    private String name;

    public Animal(String _name){
        animalsCount++;
        name=_name;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);

    public static int getAnimalsCount(){
        return animalsCount;
    }

    public String getName(){
        return name;
    }
}
