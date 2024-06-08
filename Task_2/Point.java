//Task 2, Point class
//Needed in the Triangle class and demo default interface methods

public class Point extends Figure{
    private double x,y;

    public Point(double _x, double _y){
        x=_x;
        y=_y;
    }

    @Override
    public void info(){
        System.out.println("Точка (" + this.toString() + ")");
        super.info();
    }

    @Override
    public String toString(){
        return x + ", " + y;
    }

    public double length(Point b){
        return Math.sqrt(Math.pow(this.x - b.x, 2.0) + Math.pow(this.y - b.y, 2.0));
    }
}
