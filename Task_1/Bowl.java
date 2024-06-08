//Task 1, Bowl class

public class Bowl {
    private int food;

    public Bowl(int _food){
        put(_food);
    }

    public void put(int _food){
        if (_food < 0) {
            System.out.println("Еды не может быть меньше 0! Использовано 0.");
            food = 0;
        } else
            food=_food;
    }

    public int getFood(){
        return food;
    }

    public void eat(int piece){
        if (piece > food)
            System.out.println("Нельзя съесть больше, чем есть в миске!");
        else
            food-=piece;
    }
}
