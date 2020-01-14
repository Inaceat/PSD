package Task2;

import javax.swing.*;
import java.awt.*;

class FormsExampleMainWindow
        extends JFrame
{
    private JPanel _contentPane;
    
    private JLabel _sizeHint;
    private JSpinner _widthInput;
    private JSpinner _heightInput;
    
    private JLabel _positionHint;
    private JSpinner _positionXInput;
    private JSpinner _positionYInput;
    
    private JLabel _textFieldCountHint;
    private JSpinner _textFieldCountInput;
    private JLabel _labelCountHint;
    private JSpinner _labelCountInput;
    
    private JComboBox<LayoutType> _layoutInput;
    
    private JButton _createFormButton;
    
    FormsExampleMainWindow()
    {
        _contentPane = new JPanel();
    
        _sizeHint = new JLabel("Size:");
        _widthInput = new JSpinner(new SpinnerNumberModel(400, 1, 1000, 1));
        _heightInput = new JSpinner(new SpinnerNumberModel(400, 1, 500, 1));
    
        _positionHint = new JLabel("Position:");
        _positionXInput = new JSpinner(new SpinnerNumberModel(300, 1, 1000, 1));
        _positionYInput = new JSpinner(new SpinnerNumberModel(300, 1, 500, 1));
    
        _textFieldCountHint = new JLabel("Text fields:");
        _textFieldCountInput = new JSpinner(new SpinnerNumberModel(1, 0, 5, 1));
        _labelCountHint = new JLabel("Labels:");
        _labelCountInput = new JSpinner(new SpinnerNumberModel(1, 0, 5, 1));;
    
        _layoutInput = new JComboBox<>(new DefaultComboBoxModel<>(LayoutType.values()));
        
        _createFormButton = new JButton("Create");
    
        _contentPane.add(_sizeHint);
        _contentPane.add(_widthInput);
        _contentPane.add(_heightInput);
    
        _contentPane.add(_positionHint);
        _contentPane.add(_positionXInput);
        _contentPane.add(_positionYInput);
    
        _contentPane.add(_textFieldCountHint);
        _contentPane.add(_textFieldCountInput);
        _contentPane.add(_labelCountHint);
        _contentPane.add(_labelCountInput);
    
        _contentPane.add(_layoutInput);
        
        _contentPane.add(_createFormButton);
        
        _createFormButton.addActionListener(e -> CreateForm());
        
        setContentPane(_contentPane);
        setBounds(600, 300, 400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    void Show()
    {
        setVisible(true);
    }
    
    private void CreateForm()
    {
        var form = new JFrame();
        form.setContentPane(new JPanel());
        
        switch ((LayoutType)_layoutInput.getSelectedItem())
        {
            case FlowLayout:
                form.setLayout(new FlowLayout());
                break;
                
            case BorderLayout:
                form.setLayout(new BorderLayout());
                break;
                
            case BoxLayout:
                form.setLayout(new BoxLayout(form.getContentPane(), BoxLayout.LINE_AXIS));
                break;
                
            case GridBagLayout:
                form.setLayout(new GridBagLayout());
                break;
                
            case GridLayout:
                form.setLayout(new GridLayout());
                break;
        }
        
        form.setBounds((int)_positionXInput.getValue(),(int)_positionYInput.getValue(),
                       (int)_widthInput.getValue(), (int)_heightInput.getValue());
        
        var textFieldCount = (int)_textFieldCountInput.getValue();
        var labelCount = (int)_labelCountInput.getValue();
    
        for (int i = 1; i <= textFieldCount; ++i)
        {
            form.add(new JTextField("Text" + i));
        }
    
        for (int i = 1; i <= labelCount; ++i)
        {
            var label = new JLabel("Label" + i);
            label.setEnabled(false);
            form.add(label);
        }
        
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);
    }
}
