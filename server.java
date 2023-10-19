import java.io.* ;
import java.net.*;
public class server {

    private static int[][] unserializeArray(String serializedArray) {
        String[] rows = serializedArray.split("\n");
        int rowCount = rows.length;
        int columnCount = rows[0].trim().split(" ").length;
        int[][] array = new int[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            String[] elements = rows[i].trim().split(" ");
            for (int j = 0; j < columnCount; j++) {
                array[i][j] = Integer.parseInt(elements[j]);
            }
        }

        return array;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    } 
    
    public static void main(String[] args){
        int[][] matrix1 = new int[0][];
        int[][] matrix2 = new int[0][];
        
        try{
            ServerSocket ss=new ServerSocket(6666);
            System.out.println("Server listen on port 6666 ...... ");
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String  str=(String)dis.readUTF();
            matrix1=unserializeArray(str);
            System.out.println("the second matrix");
            printArray(matrix1);
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }


        try{
            ServerSocket ss=new ServerSocket(6666);
            System.out.println("Server listen on port 6666 ...... ");
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String  str=(String)dis.readUTF();
            matrix2=unserializeArray(str);
            System.out.println("the first matrix");
            printArray(matrix2);
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
        int[][] result=multiplyMatrices(matrix1,matrix2);
        System.out.println("the result of multiplication\n");
        printArray(result);
        
    }
}
