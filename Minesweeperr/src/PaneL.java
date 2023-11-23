import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PaneL extends JPanel implements ActionListener {

   ArrayList<Button> mines=new ArrayList<>();
   HashMap <Button,Integer> numbers = new HashMap<>();

    Button[][] button = new Button[12][12];
    public PaneL() {}
    public void panel3() {}
    public PaneL(int in) {

        setLayout(new GridLayout(12,12));
        for(int i =0 ; i<12 ; i++){
            for(int j=0;j<12;j++) {
                // Button button1 = new Button();
                button[i][j] = new Button();
                // button1 = button[i][j] ;
                add(button[i][j]);
                setBackground(new Color(in+176, 211, 232));

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
                    if(mines.contains(button[i][j])){
                        minesLose();
                    }
                    else if (numbers.containsKey(button[i][j])){
                        button[i][j].setEnabled(false);
                        int n=numbers.get(button[i][j]);
                        String s=Integer.toString(n);
                        button[i][j].setText(s);
                        button[i][j].setBackground(new Color(0xA1F3F3));
                    }else{

                        floodFill(i,j);
                    }

                }

            }
        }
    }

    Random random = new Random();
    public void setMines(){
        for (int i=0 ;i<20;i++){
            int x= random.nextInt(12);
            int y=random.nextInt(12);
            mines.add(button[x][y]);


        }
    }
    public void minesLose(){
        for (Button b :mines){
            b.setText("💣");
            b.setBackground(new Color(0xFFFF0000, true));
        }
    }

    public void setNum(){
        int count=0;
        for (int i=0 ;i<12;i++){
            for (int j=0 ;j<12;j++){
                count += checkMines(i-1, j-1);  //top left
                count += checkMines(i-1, j);    //top
                count += checkMines(i-1, j+1);  //top right

                //left and right
                count += checkMines(i, j-1);    //left
                count += checkMines(i, j+1);    //right

                //bottom 3
                count += checkMines(i+1, j-1);  //bottom left
                count += checkMines(i+1, j);    //bottom
                count += checkMines(i+1, j+1);  //bottom right

                if(count>0)
                numbers.put(button[i][j],count);
                else {
                    button[i][j].setText("");
                }
                count=0;
            }
            }
    }

    public void floodFill(int i ,int j){
        if(checkNumber(i,j)){
            button[i][j].setEnabled(false);
//            int n=numbers.get(button[i][j]);
//            String s=Integer.toString(n);
//            button[i][j].setText(s);
            button[i][j].setBackground(new Color(0xA1F3F3));
        }else{
            if (i< 0 ) {
                floodFill(i+1, j-1);    //left
                button[i+1][j].setBackground(new Color(0xA1F3F3));
                return;
            }
            button[i][j].setBackground(new Color(0xA1F3F3));
//            floodFill(i-1, j-1);  //top left
            floodFill(i-1, j);    //top
//            floodFill(i-1, j+1);  //top right
//            floodFill(i, j-1);    //left
//            floodFill(i, j+1);    //right
//            floodFill(i+1, j-1);  //bottom left
//            floodFill(i+1, j);    //bottom
//            floodFill(i+1, j+1);  //bottom right
        }
    }


    public int checkMines(int i,int j){
        if (i < 0 || i >= 11 || j < 0 || j >= 11) {
            return 0;
        }
        if (mines.contains(button[i][j])) {
            return 1;
        }
        return 0;
    }
    public boolean checkNumber(int i,int j){
        if (i < 0 || i >= 11 || j < 0 || j >= 11) {
            return false;
        }
        if (numbers.containsKey(button[i][j])) {
            return true;
        }
        return false;
    }

    }


