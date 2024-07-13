import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    //     System.out.println("before transpese");
    //     print(matrix);
    // //     transperse(matrix, 4);
    // //     System.out.println("after transpese");
    // //    print(matrix);
    //    rotatematrix(matrix);
    //    System.out.println("after rotation");
    //    print(matrix);
    }

    public static void print(int matrix[][] ) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void transperse(int matrix[][], int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix,i,j);
            }
        }
    }

    public static void swap(int matrix[][],int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void rotatematrix(int matrix[][]){
        int n = matrix.length;
        transperse(matrix, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;     
            }
        }
    }

    public static void rotatematrixanticlock(int matrix[][],int n){
        transperse(matrix, n);
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;     
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;   
        int m = matrix[0].length;
        int startRow =0;
        int endRow = n-1;
        int startCol =0;
        int endCol = m-1;

        while (startRow<=endRow && startCol<=endCol) {

            //first row
            for (int i = startCol; i <=endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow+=1;

            //end column
            for (int j = startRow; j <=endRow; j++) {
                result.add(matrix[j][endCol]);
            }
            endCol-=1;

            if (startRow<=endRow) {
                 //end row
            for (int i = endCol; i >= startCol; i--) {
                result.add(matrix[endRow][i]);
            }
            endRow-=1;
            }
           
            if (startCol<=endCol) {
                 // first colum
            for (int j = endRow; j >=startRow; j--) {
                result.add(matrix[j][startCol]);
            }
            startCol+=1;
            }

           
        }

        return result;
    }

}
