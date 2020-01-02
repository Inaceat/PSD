package Task1;

import Task1.UI.ArrayUI;
import Task1.UI.MenuItem;
import Task1.Work.ArrayWorker;

class ArrayProcessor
{
    private ArrayUI     _arrayUI;
    private ArrayWorker _worker;

    ArrayProcessor()
    {
        _arrayUI = new ArrayUI(MenuItem.GetNames());

        _worker = new ArrayWorker();
    }

    void Start()
    {
        while (true)
        {
            switch (_arrayUI.AskMenuItemFromUser())
            {
                case FillArrayRandomly:
                    _worker.SetRandomArray(_arrayUI.ReadArraySize());
                    break;
                    
                case ReadArray:
                    _worker.SetArray(_arrayUI.ReadRealArray());
                    break;
                    
                case ShowArray:
                    _arrayUI.Write(_worker.GetArray());
                    break;
                    
                case Do1:
                    _arrayUI.Write("Do1 result:");
                    _arrayUI.Write(_worker.Do1());
                    break;
                    
                case Do2:
                    _worker.Do2();
                    break;
                    
                case Exit:
                    return;
            }
        }
    }
}
