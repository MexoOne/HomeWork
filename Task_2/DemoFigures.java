//Task 2, demo for classes: Point, Circle, Rectangle, Triangle

public class DemoFigures {
    public static void main (String[] args){
        Figure[] figs=new Figure[4];

        figs[0]=new Point(1, 2);
        figs[1]=new Circle(0, 0, 3);
        figs[1].setColors("Жёлтый", "Красный");
        figs[2]=new Rectangle(1, 1, 3, 4);
        figs[2].setColors("Зелёный", "Синий");
        figs[3]=new Triangle(0, 0, 0, 3, 4, 0);
        figs[3].setColors("Оранжевый", "Фиолетовый");

        for (int i=0; i<4; i++){
            System.out.println("-----------------------------------------------------------");
            figs[i].info();
        }
    }
}
