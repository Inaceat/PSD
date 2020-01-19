package Topic;

import Subject.SubjectData;

import javax.swing.*;
import java.awt.*;

public class TopicsWindow
        extends JFrame
{
    private JPanel _tablePane;
    
    public TopicsWindow(SubjectData subject)
    {
        
        _tablePane = new TopicsTableView(subject);
        
        setLayout(new BorderLayout());
        
        add(_tablePane, BorderLayout.CENTER);
        
        setBounds(350, 300, 700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
