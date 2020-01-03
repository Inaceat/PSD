package Task2;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        String fileName = "data/matrix.csv";

        MatrixCSVSerializer serializer;
        try
        {
            serializer = new MatrixCSVSerializer(fileName);
        }
        catch (IOException e)
        {
            System.out.println("Data file not found!");
            return;
        }

        Matrix matrix;
        try
        {
            matrix = serializer.ReadMatrix();
        }
        catch (IOException e)
        {
            System.out.println("Data file read failed!");
            return;
        }

        System.out.println(matrix.toString());

        SomeMatrixElements result = matrix.FindSomeElements();

        System.out.println(result.toString());
    }
}
