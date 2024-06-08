//Task 1, HungryCat class

public class HungryCat extends Cat{
    final private int hungry;
    final static private int defHungry=15;

    private boolean satiety;

    public HungryCat(String _name, int _hungry){
        super(_name);
        satiety=false;
        if (_hungry >= 0)
            hungry = _hungry;
        else {
            System.out.println("Голод не может быть отрицательным! Использовано " + defHungry + ".");
            hungry = defHungry;
        }
    }

    public void eatFrom(Bowl bowl){
        if (satiety){
            System.out.println("Кот " + getName() + " уже сыт!");
            return;
        }
        if (bowl.getFood() >= hungry){
            bowl.eat(hungry);
            satiety=true;
            System.out.println("Кот " + getName() + " успешно поел.");
        } else
            System.out.println("Коту " + getName() + " не хватает еды в миске!");
    }

    public boolean isSatiety(){
        return satiety;
    }
}
