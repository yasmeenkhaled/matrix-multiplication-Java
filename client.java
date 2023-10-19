import java.io.* ;
import java.net.*;
public class client {

    private static String serializeArray(int[][] array) {
        // Convert the 2D array to a serialized form (e.g., JSON)
        // Implement your serialization logic here
        // This is just a dummy implementation for demonstration purposes
        StringBuilder sb = new StringBuilder();
        for (int[] row : array) {
            for (int element : row) {
                sb.append(element).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String serializedmatrix=serializeArray(matrix);
        try{
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF(serializedmatrix);
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }

}