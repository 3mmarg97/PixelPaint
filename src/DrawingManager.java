import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingManager implements MouseListener {

    private static boolean isPressed;
    private Tool tool = new Pen();

    public void setTool(String tool) {
        switch (tool){
            case "Pen":
                this.tool = new Pen();
                break;
            case "Brush":
                this.tool = new Brush();
                break;
        }
    }

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
