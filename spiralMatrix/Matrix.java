
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{12,16,23,33},{45,67,87,98}};
        System.out.println("before transpese");
        print(matrix);
        transperse(matrix, 4);
        System.out.println("after transpese");
       print(matrix);
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



}
