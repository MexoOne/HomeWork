//Task 2, basic Figure class

public class Figure implements FigureCalcs, FigureColors, FigureInfo{
    private String fillColor="Прозрачный";
    private String lineColor="Без контура";

    @Override
    public void setColors(String fill, String line){
        fillColor=fill;
        lineColor=line;
    }

    @Override
    public String getFillColor(){
        return fillColor;
    }

    @Override
    public String getLineColor(){
        return lineColor;
    }

    @Override
    public void info(){
        System.out.println("Периметр: " + perimeter() + "  Площадь: " + area());
        System.out.println("Цвет заливки: " + getFillColor() + "  Цвет границ: " + getLineColor());
    }
}
