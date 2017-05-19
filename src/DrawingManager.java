import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingManager implements MouseListener {

    private static boolean isPressed;
    private Tool tool;


    @Override
    public void mouseClicked(MouseEvent e) {
        // Not Used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not Used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (isPressed)
            tool.draw((JPanel)e.getSource());
    }


}
