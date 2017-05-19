import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {

    private JPanel toolsBox, drawPanel, cells[];
    private ButtonGroup toolsGroup, colorsGroup;
    private JRadioButton toolPen, toolSquare, toolBrush;
    private JRadioButton colorRed, colorGreen, colorBlue, colorBlack, colorWhite;
    private JButton saveBtn, openBtn;
    private JLabel separator;


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
        toolSquare  = new JRadioButton("Square");
        toolBrush   = new JRadioButton("Brush");

        colorRed    = new JRadioButton("Red");
        colorGreen  = new JRadioButton("Green");
        colorBlue   = new JRadioButton("Blue");
        colorBlack  = new JRadioButton("Black");
        colorWhite  = new JRadioButton("White");

        saveBtn     = new JButton("Save");
        openBtn     = new JButton("Open");

        toolPen.setSelected(true);
        colorBlack.setSelected(true);

        toolsGroup.add(toolPen);
        toolsGroup.add(toolSquare);
        toolsGroup.add(toolBrush);

        toolsBox.add(toolPen);
        toolsBox.add(toolBrush);
        toolsBox.add(toolSquare);

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

        toolsBox.add(saveBtn);
        toolsBox.add(openBtn);

        toolsBox.setPreferredSize(new Dimension(100, 500));
    }

    private void createDrawPanel() {
        drawPanel   = new JPanel();
        cells       = new JPanel[10000];

        drawPanel.setLayout(new GridLayout(100, 100));

        drawPanel.setPreferredSize(new Dimension(500, 500));
        DrawingManager drawingManager = new DrawingManager();
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                JPanel currCell = new JPanel();
                cells[y*100+x] = currCell;
                currCell.addMouseListener(drawingManager);
                currCell.setBackground(Color.WHITE);
                drawPanel.add(currCell);
            }
        }

    }
}
