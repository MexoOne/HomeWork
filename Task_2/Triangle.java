//Task2, Triangle class

public class Triangle extends Figure{
    private Point a, b, c;

    public Triangle(double xa, double ya,
                    double xb, double yb,
                    double xc, double yc){
        a=new Point(xa, ya);
        b=new Point(xb, yb);
        c=new Point(xc, yc);
    }

    @Override
    public double perimeter(){
        return a.length(b) + b.length(c) + c.length(a);
    }

    @Override
    public double area(){
        double ab=a.length(b);
        double bc=b.length(c);
        double ca=c.length(a);
        double p2=(ab+bc+ca)/2.0;
        return Math.sqrt(p2 * (p2-ab) * (p2-bc) * (p2-ca));
    }

    @Override
    public void info(){
        System.out.println("Треугольник (" + a + "; " + b + "; " + c + ")");
        super.info();
    }
}
