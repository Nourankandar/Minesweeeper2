import javax.swing.*;
import java.awt.*;


public class Button extends JButton {
    mouseListener mouseListener = new mouseListener();
    public Button(){
        setBackground(new Color(176, 211, 232));
        setText("");
        this.addMouseListener(mouseListener);

    }
}