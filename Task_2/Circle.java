//Task 2, Circle class

public class Circle extends Figure{
    private double x0, y0, r;

    public Circle(double _x0, double _y0, double _r){
        x0=_x0;
        y0=_y0;
        if (_r >= 0)
            r=_r;
        else {
            System.out.println("Радиус не сможет быть меньше 0! Использовано 0.");
            r=0;
        }
    }

    @Override
    public double perimeter(){
        return 2 * Math.PI * r;
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(r, 2.0);
    }

    @Override
    public void info(){
        System.out.println("Круг (" + x0 + ", " + y0 + "; " + r + ")");
        super.info();
    }
}
