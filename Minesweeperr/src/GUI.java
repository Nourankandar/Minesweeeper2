import javax.swing.*;

public class GUI extends JFrame {
    PaneL paneL = new PaneL(5);
    PaneL paneL1 = new PaneL();
    PaneL paneL2 = new PaneL();


    public GUI(){
        setSize(618,620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("MineSweeper");
        setLocation(500, 100);
        setLayout(null);
        paneL.setBounds(2,100,600,480);

        paneL.panel3();
        paneL1.panel1(paneL1);
        paneL2.panel2(paneL2);

        add(paneL1);add(paneL2); add(paneL);
        paneL.setMines();
        paneL.setNum();

        setVisible(true);
    }


}
