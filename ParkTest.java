//Task3, main, test Park class

public class ParkTest {
    public static void main(String[] args){
        Park park=new Park();

        Park.Attraction attr= park.new Attraction("Carousel", 10, 20, 1.5);
        System.out.println(attr.getName()+" "+attr.getOpen()+" "+attr.getClose()+" "+attr.getCost());
        System.out.println();
        park.add(attr);

        park.add("Swing", 11, 18, 0.6);

        park.printAll();
    }
}
