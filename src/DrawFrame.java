import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrame extends JFrame implements ActionListener{

    private JPanel toolsBox, drawPanel, cells[];
    private ButtonGroup toolsGroup, colorsGroup;
    private JRadioButton toolPen, toolBrush;
    private JRadioButton colorRed, colorGreen, colorBlue, colorBlack, colorWhite;
    private JButton clearBtn, saveBtn, openBtn;
    private JLabel separator;
    private DrawingManager drawingManager;
    private FilesManagement file = new FilesManagement();

    public DrawFrame(String name) {
        super(name);

        createToolsBox();
        createDrawPanel();

        add(toolsBox);
        add(drawPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(610, 510);
        setResizable(false);
        setVisible(true);
    }

    private void createToolsBox(){
        toolsBox    = new JPanel();

        separator   = new JLabel("ــــــــــــــــــــــــــ");

        toolsGroup  = new ButtonGroup();
        colorsGroup = new ButtonGroup();

        toolPen     = new JRadioButton("Pen");
        toolBrush   = new JRadioButton("Brush");

        toolPen.addActionListener(this);
        toolBrush.addActionListener(this);

        colorRed    = new JRadioButton("Red");
        colorGreen  = new JRadioButton("Green");
        colorBlue   = new JRadioButton("Blue");
        colorBlack  = new JRadioButton("Black");
        colorWhite  = new JRadioButton("White");

        colorRed.addActionListener(this);
        colorGreen.addActionListener(this);
        colorBlue.addActionListener(this);
        colorBlack.addActionListener(this);
        colorWhite.addActionListener(this);

        clearBtn    = new JButton("Clear");
        saveBtn     = new JButton("Save");
        openBtn     = new JButton("Open");

        clearBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        openBtn.addActionListener(this);

        toolPen.setSelected(true);
        colorBlack.setSelected(true);

        toolsGroup.add(toolPen);
        toolsGroup.add(toolBrush);

        toolsBox.add(toolPen);
        toolsBox.add(toolBrush);

        toolsBox.add(separator);

        colorsGroup.add(colorRed);
        colorsGroup.add(colorGreen);
        colorsGroup.add(colorBlue);
        colorsGroup.add(colorBlack);
        colorsGroup.add(colorWhite);

        toolsBox.add(colorBlack);
        toolsBox.add(colorWhite);
        toolsBox.add(colorRed);
        toolsBox.add(colorGreen);
        toolsBox.add(colorBlue);

        toolsBox.add(clearBtn);
        toolsBox.add(saveBtn);
        toolsBox.add(openBtn);

        toolsBox.setPreferredSize(new Dimension(100, 500));
    }

    private void createDrawPanel() {
        drawPanel   = new JPanel();
        cells       = new JPanel[10000];

        drawPanel.setLayout(new GridLayout(100, 100));

        drawPanel.setPreferredSize(new Dimension(500, 500));
        drawingManager = new DrawingManager();
        for (int i = 0; i < 10000; i++) {
                JPanel currCell = new JPanel();
                cells[i] = currCell;
                currCell.addMouseListener(drawingManager);
                currCell.setBackground(Color.WHITE);
                drawPanel.add(currCell);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorRed)
            Tool.setColor(Color.RED);
        else if (e.getSource() == colorGreen)
            Tool.setColor(Color.GREEN);
        else if (e.getSource() == colorBlue)
            Tool.setColor(Color.BLUE);
        else if (e.getSource() == colorBlack)
            Tool.setColor(Color.BLACK);
        else if (e.getSource() == colorWhite)
            Tool.setColor(Color.WHITE);
        else if (e.getSource() == saveBtn)
            file.save(cells);
        else if (e.getSource() == openBtn)
            file.open(cells);
        else if (e.getSource() == clearBtn)
            for (int i = 0; i < cells.length; i++) {
                cells[i].setBackground(Color.WHITE);
            }
        else
            drawingManager.setTool(((JRadioButton)e.getSource()).getText());
    }
}
