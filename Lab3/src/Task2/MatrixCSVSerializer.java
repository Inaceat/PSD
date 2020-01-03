package Task2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class MatrixCSVSerializer
{
    private String _filePath;

    MatrixCSVSerializer(String dataFilePath)
            throws IOException
    {
        _filePath = dataFilePath;
        if (!Files.isReadable(Paths.get(dataFilePath)))
            throw new IOException();
    }

    Matrix ReadMatrix()
            throws IOException
    {
        String[] dataLines = Files.lines(Paths.get(_filePath)).toArray(String[]::new);


        var rows = dataLines.length;
        if (rows < 1)
            return new Matrix(0,0);

        var columns = (int) dataLines[0].chars().filter(c -> c == ';').count() + 1;

        for (var line : dataLines)
        {
            if (columns != line.chars().filter(c -> c == ';').count() + 1)
                throw new IOException();
        }


        var matrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; ++i)
        {
            var line = dataLines[i].split(";");
            for (int j = 0; j < columns; j++)
            {
                matrix.SetElementAt(i, j, Integer.parseInt(line[j]));
            }
        }

        return matrix;
    }
}
