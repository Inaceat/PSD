package Task1;

public class ArrayProcessor
{
    private ArrayUI     _arrayUI;
    private ArrayWorker _worker;

    public ArrayProcessor()
    {
        _arrayUI = new ArrayUI(MenuItem.GetNames());

        _worker = new ArrayWorker();
    }

    public void Start()
    {
        while (true)
        {
            switch (_arrayUI.AskMenuItemFromUser())
            {
                case Exit:
                    return;

                case PrintHello:
                    _arrayUI.Write("Hello");
                    break;

                case Echo:
                    var x = new double[2];
                    x[0] = 0.12;
                    x[1] = -213.313;
                    _arrayUI.Write(x);
                    break;

                default:
                    break;
            }
        }
    }
}
