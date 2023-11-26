import javax.swing.*;

public class GUI extends JFrame {

    PaneL paneL1 = new PaneL();
    PaneL paneL2 = new PaneL();
    PaneL paneL3 = new PaneL(5);


    public GUI(){
        setSize(618,620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("MineSweeper");
        setLocation(500, 100);
        setLayout(null);
        paneL3.setBounds(2,100,600,480);

        paneL1.panel1(paneL1);
        paneL2.panel2(paneL2);

        add(paneL1);add(paneL2); add(paneL3);
        paneL3.setMines();
        paneL3.setNum();

        setVisible(true);
    }


}
