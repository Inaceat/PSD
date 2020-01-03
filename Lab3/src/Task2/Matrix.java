package Task2;

import java.util.Arrays;

class Matrix
{
    private int _rows;
    private int _columns;
    private int[][] _matrix;

    Matrix(int rows, int columns)
    {
        _rows = rows;
        _columns = columns;

        _matrix = new int[rows][columns];
    }

    int ElementAt(int row, int column)
            throws IllegalArgumentException
    {
        if (row < 0 || _rows <= row ||
            column < 0 || _columns <= column)
        {
            throw new IllegalArgumentException();
        }

        return _matrix[row][column];
    }

    void SetElementAt(int row, int column, int value)
            throws IllegalArgumentException
    {
        if (row < 0 || _rows <= row ||
            column < 0 || _columns <= column)
        {
            throw new IllegalArgumentException();
        }

        _matrix[row][column] = value;
    }


    SomeMatrixElements FindSomeElements()
    {
        int min = Integer.MAX_VALUE;
        int minRow = -1;
        int minColumn = -1;

        for (int i = 0; i < _rows; i++)
        {
            for (int j = 0; j < _columns; j++)
            {
                if (_matrix[i][j] < min)
                {
                    min = _matrix[i][j];
                    minRow = i;
                    minColumn = j;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxColumn = -1;

        for (int i = 0; i < minRow; i++)
        {
            for (int j = minColumn + 1; j < _columns; j++)
            {
                if (_matrix[i][j] >= max)
                {
                    max = _matrix[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        return new SomeMatrixElements(min, minRow, minColumn, max, maxRow, maxColumn);
    }

    @Override
    public String toString()
    {
        var result = new StringBuilder();

        for (int i = 0; i < _rows; i++)
        {
            for (int j = 0; j < _columns; j++)
            {
                result.append(ElementAt(i, j)).append(", ");
            }

            result.delete(result.length() - 2, result.length() - 1);
            result.append("\n");
        }

        return result.toString();
    }
}
