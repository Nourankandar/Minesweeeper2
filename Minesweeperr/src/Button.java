import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class Button extends JButton implements MouseListener {
     PaneL paneL;
    Button button;
    public Button(PaneL paneL){
        this.paneL = paneL;
    }
    public Button(){
        setBackground(new Color(176, 211, 232));
        setText("");
        MouseListener mouseListener1 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                button=(Button) e.getSource();
                if (e.getButton()==MouseEvent.BUTTON3){
                    button.addMouseListener(this);
                    button .setText("r");
                    button.setEnabled(false);


                }
               if (e.getButton()==MouseEvent.BUTTON1){

               }
            }
        };
        addMouseListener(mouseListener1);



    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}