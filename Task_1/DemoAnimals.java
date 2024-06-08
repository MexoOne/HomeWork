//Task 1, demo for classes: Animal, Dog, Cat, HungryCat, Bowl

public class DemoAnimals {
    public static void main(String[] args){
        System.out.println("== Creating 1 cat and 2 dog ==");
        Cat vaska=new Cat("Васька");
        Dog strelka=new Dog("Стрелка");
        Dog belka=new Dog("Белка");
        System.out.println("Cats: " + Cat.getCatsCount() + ", Dogs: " + Dog.getDogsCount() +
                ", Total animals: " + Animal.getAnimalsCount());
        System.out.println();

        System.out.println("== Animals run ==");
        belka.run(450);
        strelka.run(550);
        vaska.run(150);
        vaska.run(250);
        System.out.println();

        System.out.println("== Animals swim ==");
        belka.swim(15);
        strelka.swim(5);
        vaska.swim(10);
        System.out.println();

        System.out.println("== Cats feeding ==");
        final int N=5;
        final int normHungry=15;
        final int lowHungry=5;
        int foodCount=(N-1-1)*normHungry + lowHungry;

        Bowl bowl=new Bowl(foodCount);
        HungryCat[] cats=new HungryCat[N];
        for (int i=0; i<N-1; i++)
            cats[i]=new HungryCat("Пушок №" + (i+1), normHungry);
        cats[N-1]=new HungryCat("Пушок №"+N, lowHungry);

        for (int i=0; i<N; i++)
            cats[i].eatFrom(bowl);
        System.out.println();

        for (int i=0; i<N; i++)
            System.out.println("Кот " + cats[i].getName() + ((cats[i].isSatiety()) ? " сыт." : " голоден."));
    }
}
