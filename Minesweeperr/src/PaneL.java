import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PaneL extends JPanel implements ActionListener {

   // mouseListener mouseListener = new mouseListener();
   ArrayList<Button> mines=new ArrayList<>();

   ImageIcon imageIcon= new ImageIcon("images.png");
    Button[][] button = new Button[12][12];
    public PaneL() {}
    public PaneL(int in) {

        setLayout(new GridLayout(12,12));
        for(int i =0 ; i<12 ; i++){
            for(int j=0;j<12;j++) {
                // Button button1 = new Button();
                button[i][j] = new Button();
                // button1 = button[i][j] ;
                add(button[i][j]);
                setBackground(new Color(176, 211, 232));

            }
        }
        for (int i=0 ;i<12;i++){
            for (int j=0 ;j<12;j++){
                button[i][j].addActionListener(this);

            }
        }

    }

    public void panel1(JPanel p1){
        p1.setLayout(new GridLayout());
        p1.setBounds(2,2,600,40);
        p1.setBackground(new Color(0x7C8882));
        JMenuBar bar =new JMenuBar();

        JMenu Game =new JMenu("Game");
        JMenuItem New =new JMenuItem("new");
        JMenuItem Save =new JMenuItem("save");
        JMenuItem Load =new JMenuItem("load");

        Game.add(New);Game.add(Save);Game.add(Load);

        JMenu Settings =new JMenu("Settings");
        JMenuItem Time =new JMenuItem("time");
        JMenuItem Player =new JMenuItem("player mode");

        Settings.add(Time); Settings.add(Player);

        bar.add(Game); bar.add(Settings);

        p1.add(bar);


    }

    public void panel2(JPanel p2){
        p2.setLayout(null);
        p2.setBounds(2,44,600,55);
        p2.setBackground(new Color(0xB27EFF));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0 ;i<12;i++){
            for (int j=0 ;j<12;j++){
                if (e.getSource()== button[i][j]){
                    if(button[i][j].getText()== " "){
                        mineslose();
                    }
                }

            }
        }
    }
    public void panel3() {

    }
    Random random = new Random();
    public void setMines(){
        for (int i=0 ;i<20;i++){
            int x= random.nextInt(11);
            int y=random.nextInt(11);
            mines.add(button[x][y]);
            button[x][y].setIcon(imageIcon);
            button[x][y].setText(" ");



        }
    }
    public void mineslose(){
        for (Button b :mines){
            b.setText("💣");
            b.setBackground(new Color(0x01B692));
        }
    }
}

