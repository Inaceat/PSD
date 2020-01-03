package Task2;

public class SomeMatrixElements
{
    private int _firstMin;
    private int _firstMinRow;
    private int _firstMinColumn;

    private int _lastMax;
    private int _lastMaxRow;
    private int _lastMaxColumn;

    SomeMatrixElements(int firstMin, int minRow, int minColumn, int lastMax, int maxRow, int maxColumn)
    {
        _firstMin = firstMin;
        _firstMinRow = minRow;
        _firstMinColumn = minColumn;

        _lastMax = lastMax;
        _lastMaxRow = maxRow;
        _lastMaxColumn = maxColumn;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        result.append("First minimum element is ").append(_firstMin).append(", at {").append(_firstMinRow).append("; ").append(_firstMinColumn).append("}\n");
        result.append("Last maximum element is ").append(_lastMax).append(", at {").append(_lastMaxRow).append("; ").append(_lastMaxColumn).append("}\n");

        return result.toString();
    }
}
