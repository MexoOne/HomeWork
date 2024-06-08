//Task 2, calculations interface

public interface FigureCalcs {
    default double perimeter(){
        return 0.0;
    }

    default double area(){
        return 0.0;
    }
}
