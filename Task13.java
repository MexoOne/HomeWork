public class Task13 {
    final static int N=6;

    public static void main(String[] arg0){
        int[][] matrix=createAndFill(N);
        System.out.println("Before:");
        printMatrix(matrix);
        changeDiagonals(matrix);
        System.out.println("After:");
        printMatrix(matrix);
    }

    public static int[][] createAndFill(int n){
        int[][] m=new int[n][n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                m[i][j]=0;
        return m;
    }

    public static void changeDiagonals(int[][] m){
        for (int i=0; i<m.length; i++){
            m[i][i]=1;
            m[i][m.length-i-1]=1;
        }
    }

    public static void printMatrix(int[][] m){
        for (int[] line: m) {
            for (int cell : line)
                System.out.print("\t" + cell);
            System.out.println();
        }
    }
}
