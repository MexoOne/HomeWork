//Task 2, Rectangle class

public class Rectangle extends Figure{
    private double x0,y0,x1,y1;

    public Rectangle(double _x0, double _y0, double _x1, double _y1){
        x0=Math.min(_x0, _x1);
        y0=Math.min(_y0, _y1);
        x1=Math.max(_x0, _x1);
        y1=Math.max(_y0, _y1);
    }

    @Override
    public double perimeter() {
        return 2*(x1-x0) + 2*(y1-y0);
    }

    @Override
    public double area(){
        return (x1-x0) * (y1-y0);
    }

    @Override
    public void info(){
        System.out.println("Прямоугольник (" + x0 + ", " + y0 + "; " + x1 + ", " + y1 + ")");
        super.info();
    }
}
