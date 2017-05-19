import javax.swing.*;
public class Pen extends Tool {

    @Override
    public void draw(JPanel panel){
        panel.setBackground(Tool.color);
    }

}
