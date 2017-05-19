import javax.swing.*;
import java.awt.*;

public class Brush extends Tool{

    @Override
    public void draw(JPanel panel) {
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        panel.setBackground(Tool.color);
    }
}
