import java.io.*;
import java.util.*;

class Matrix{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        
        //Taking input of number of rows and colums
        System.out.println("Enter number of rows in matrix 1");
        int r1=sc.nextInt();
        System.out.println("Enter number of columns in matrix 1");
        int c1=sc.nextInt();
        
        //Creating two matrices and taking input for their values
        int matrix1[][]=new int[r1][c1];
        System.out.println("Enter elements of matrix 1");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                matrix1[i][j]=sc.nextInt();
            }
        }
        
        int matrix2[][]=new int[r1][c1];
        System.out.println("Enter elements of matrix 2");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                matrix2[i][j]=sc.nextInt();
            }
        }
        
        //Printing both the matrices using printMatrix() funtion
        System.out.println("\nMatrix 1:");
        printMatrix(matrix1,r1,c1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2,r1,c1);
        
        //Taking transpose of both matrices one at a time using transpose() function and printing them
        transpose(matrix1,r1,c1);
        System.out.println("\nTransposed Matrix 1:");
        printMatrix(matrix1,r1,c1);
        transpose(matrix2,r1,c1);
        System.out.println("Transposed Matrix 2:");
        printMatrix(matrix2,r1,c1);
        
        //Performing matrix multiplication on transpose matrices
        System.out.println("\nMultiplication of transposed matrices is:");
        multiplyMatrix(matrix1, matrix2, r1,c1);
    }
    
    /*Function to print any matrix
      Time Complexity: O(N^2)
      Auxiliary Space: O(1)
    */
    public static void printMatrix(int[][] arr,int row, int column){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    /*Function to transpose any matrix
      Time Complexity: O(N^2)
      Auxiliary Space: O(1)
      Approach:
      Transpose of a matrix is done by changing rows to columns and
      columns to rows,i.e., transpose of arr[row][column] is obtained by 
      changing arr[i][j] to arr[j][i].
    */
    public static void transpose(int[][] arr,int row, int column)
    {
        for(int i=0;i<row;i++){
            for (int j=i+1;j<column;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    
    /*Function to matrix multiplication
      Time Complexity: O(N^3), as we are using a nested loop for traversing.
      Auxiliary Space: O(N^2), as an extra resultant 2-D array is created.
      Approach:
      1)Check if the two taken matrices are compatible to be multiplied,ie.,
      columns of matrix1=rows of matrix2 (Here this is not required as both 
      rows and columns have same count.
      2)Create a new Matrix to store the multiplication
      3)Each element of the two matrices is traversed and multiplied.
        This product is stored at the corresponding ndex of resultant matrix.
      */
    static void multiplyMatrix(int matrix1[][], int matrix2[][],int row, int col)
    {
        int multiply[][] = new int[row][col];
        
        /*
        Condition of to if multiplication is possible or not is not required because
        the number or rows and colums remain same in both matrices according to question.
           if (row2 != col1) {
 
            System.out.println(
                "\nMultiplication Not Possible");
            return;
            }
        */
       
        // Multiply the two matrices
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                for (int k=0;k<row;k++)
                    multiply[i][j]+=matrix1[i][k]*matrix2[k][j];
            }
        }
        printMatrix(multiply,row,col);
    }
}



