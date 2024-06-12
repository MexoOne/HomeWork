public class ExceptionDemo {
    static class MyArraySizeException extends Exception{
        MyArraySizeException(){
            super("Размер матрицы отличается от 4х4!");
        }
    }

    static class MyArrayDataException extends Exception{
        MyArrayDataException(int i, int j){
            super("Строка в ячейке ["+i+"]["+j+"] отличается от представления int!");
        }
    }

    final static int N=4;

    public static void main(String[] args){
        System.out.println(" === Хорошая матрица ===");
        String[][] matrix=createAndFill(N);
        printMatrix(matrix);
        try {
            System.out.println("Sum: " + sumMatrix(matrix));
        }catch (Exception e){
            System.out.println("Сюда не попадём");
        }
        System.out.println();

        System.out.println(" === Матрица не того размера ===");
        matrix=createAndFill(N+1);
        printMatrix(matrix);
        try {
            System.out.println("Sum: " + sumMatrix(matrix));
        } catch (MyArraySizeException e){
            System.out.println(e);
        } catch (Exception e){
            System.out.println("Сюда не попадём");
        }
        System.out.println();

        System.out.println(" === Матрица с неверным элементом ===");
        matrix=createAndFill(N);
        matrix[1][2]="XYZ";
        printMatrix(matrix);
        try {
            System.out.println("Sum: " + sumMatrix(matrix));
        } catch (MyArrayDataException e){
            System.out.println(e);
        } catch (Exception e){
            System.out.println("Сюда не попадём");
        }
    }

    public static int sumMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException{
        if (matrix.length != N)
            throw new MyArraySizeException();

        int sum=0;
        for (int i=0; i<matrix.length; i++){
            if (matrix[i].length != N)
                throw new MyArraySizeException();
            for (int j=0; j<matrix[i].length; j++) {
                try {
                    int cell = Integer.parseInt(matrix[i][j]);
                    sum = sum + cell;
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public static String[][] createAndFill(int size){
        String[][] matrix=new String[size][size];
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                matrix[i][j]= (j >= i)? "1": "0";
            }
        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                System.out.print("\t"+matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
