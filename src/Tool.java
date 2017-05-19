import javax.swing.*;
import java.awt.*;

public abstract class Tool {

    static Color color = Color.BLACK;

    public static void setColor(Color color) {
        Tool.color = color;
    }

    public abstract void draw(JPanel panel);
}
