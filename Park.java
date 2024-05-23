//Task3, Park class

import java.util.ArrayList;

public class Park {
    public class Attraction{
        private String name;
        private int hourOpen;
        private int hourClose;
        private double cost;

        public Attraction(String _name, int _hOpen, int _hClose, double _cost){
            name=_name;
            hourOpen=_hOpen;
            hourClose=_hClose;
            cost=_cost;
        }

        public String getName(){
            return name;
        }

        public int getOpen(){
            return hourOpen;
        }

        public int getClose(){
            return hourClose;
        }

        public double getCost(){
            return cost;
        }

        @Override
        public String toString(){
            return name + ", " + hourOpen + ":00-" + hourClose + ":00, $" + cost;
        }
    }

    private ArrayList<Attraction> list;

    public Park(){
        list=new ArrayList<Attraction>();
    }

    public void add(Attraction attr){
        list.add(attr);
    }

    public void add(String _name, int _hOpen, int _hClose, double _cost){
        list.add(new Attraction(_name, _hOpen, _hClose, _cost));
    }

    public void printAll(){
        for (Attraction attr: list)
            System.out.println(attr);
    }
}
