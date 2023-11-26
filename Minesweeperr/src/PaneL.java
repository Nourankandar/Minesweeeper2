import org.w3c.dom.Text;

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
    public PaneL(int in) {

        setLayout(new GridLayout(12,12)) ;
        for(int i =0 ; i<12 ; i++){
            for(int j=0;j<12;j++) {
                button[i][j] = new Button();
                add(button[i][j]);
                button[i][j].addActionListener(this);

            }
        }

    }

    public void panel1(JPanel p1){
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setBounds(2,2,600,25);
        p1.setBackground(new Color(0xFF689C));

        JMenuBar bar =new JMenuBar();
        bar.setOpaque(true);
        bar.setBackground(new Color(0xFF689C));

        JMenu Game =new JMenu("Game");
        Game.setOpaque(true);
        Game.setBackground(new Color(0xFF689C));

        JMenuItem New =new JMenuItem("new");
        JMenuItem Save =new JMenuItem("save");
        JMenuItem Load =new JMenuItem("load");

        Game.add(New);Game.add(Save);Game.add(Load);

        JMenu Settings =new JMenu("Settings");
        Settings.setOpaque(true);
        Settings.setBackground(new Color(0xFF689C));

        JMenuItem Time =new JMenuItem("time");
        JMenuItem Player =new JMenuItem("player mode");

        Settings.add(Time); Settings.add(Player);

        bar.add(Game); bar.add(Settings);

        p1.add(bar);


    }

    public void panel2(JPanel p2){
        p2.setLayout(null);
        p2.setBounds(2,29,600,69);
        p2.setBackground(new Color(0xB27EFF));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0 ;i<12;i++){
            for (int j=0 ;j<12;j++){
                if ( e.getSource() == button[i][j]){
                    button[i][j].setEnabled(false);
                    button[i][j].setBackground(Color.BLACK);
                    if(mines.contains(button[i][j])){
                        minesLose();
                    }
                    else if (numbers.containsKey(button[i][j])){
                        numFill(i,j);
                    }
                    else {

                        button[i][j].setText("");
                        floodFill(i,j);

                    }

                }

            }
        }
    }
    public  void floodFill(int i, int j){

        if (i-1 < 0 || i-1 > 11 || j -1< 0 || j-1 > 11){
            return;
        }
        else if (button[i-1][j-1].getText()==""){
           if(button[i-1][j-1].isEnabled()){

              if(checkNumbers(i-1,j-1)==-1){
                  return;
              }
              if(checkNumbers(i-1,j-1)== 1){
                  int n=numbers.get(button[i-1][j-1]);
                  String s=Integer.toString(n);
                  button[i-1][j-1].setText("m");
                  button[i-1][j-1].setEnabled(false);
                  button[i-1][j-1].setBackground(Color.CYAN);
              }
               if(checkNumbers(i-1,j-1)== 0){
                  button[i-1][j-1].setEnabled(false);
                  button[i-1][j-1].setBackground(Color.CYAN);
                  floodFill(i-1,j-1);
              }
          }
          else {
              return;
          }
      }
        //+++++++++++++++++++++++++++++++++++++++++++++
        if (i-1 < 0 || i-1 > 11 || j < 0 || j > 11){
            return;
        }
        else if (button[i-1][j].getText()==""){
            if(button[i-1][j].isEnabled()){

                if(checkNumbers(i-1,j)==-1){
                    return;
                }
                if(checkNumbers(i-1,j)== 1){
                    int n=numbers.get(button[i-1][j]);
                    String s=Integer.toString(n);
                    button[i-1][j].setText("n");
                    button[i-1][j].setEnabled(false);
                    button[i-1][j].setBackground(Color.CYAN);
                }
                if(checkNumbers(i-1,j)== 0){
                    button[i-1][j].setEnabled(false);
                    button[i-1][j].setBackground(Color.CYAN);
                    floodFill(i-1,j);
                }
            }
            else {
                return;
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++
        if (i-1 < 0 || i-1 > 11 || j+1< 0 || j+1 > 11){
            return;
        }
        else if (button[i-1][j+1].getText()==""){
            if(button[i-1][j+1].isEnabled()){

                if(checkNumbers(i-1,j+1)==-1){
                    return;
                }
                if(checkNumbers(i-1,j+1)== 1){
                    int n=numbers.get(button[i-1][j+1]);
                    String s=Integer.toString(n);
                    button[i-1][j+1].setText("o");
                    button[i-1][j+1].setEnabled(false);
                    button[i-1][j+1].setBackground(Color.CYAN);
                }
                if(checkNumbers(i-1,j+1)== 0){
                    button[i-1][j+1].setEnabled(false);
                    button[i-1][j+1].setBackground(Color.CYAN);
                    floodFill(i-1,j+1);
                }
            }
            else {
                return;
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++
        if (i < 0 || i > 11 || j -1< 0 || j-1 > 11){//left
            return;
        }
        else if (button[i][j-1].getText()==""){
            if(button[i][j-1].isEnabled()){

                if(checkNumbers(i,j-1)==-1){
                    return;
                }
                if(checkNumbers(i,j-1)== 1){
                    int n=numbers.get(button[i][j-1]);
                    String s=Integer.toString(n);
                    button[i][j-1].setText(s);
                    button[i][j-1].setEnabled(false);
                    button[i][j-1].setBackground(Color.CYAN);
                }
                if(checkNumbers(i,j-1)== 0){
                    button[i][j-1].setEnabled(false);
                    button[i][j-1].setBackground(Color.CYAN);
                    floodFill(i,j-1);
                }
            }
            else {
                return;
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++
        if (i < 0 || i > 11 || j +1< 0 || j+1 > 11){
            return;
        }
        else if (button[i][j+1].getText()==""){
            if(button[i][j+1].isEnabled()){

                if(checkNumbers(i,j+1)==-1){
                    return;
                }
                if(checkNumbers(i,j+1)== 1){
                    int n=numbers.get(button[i][j+1]);
                    String s=Integer.toString(n);
                    button[i][j+1].setText("p");
                    button[i][j+1].setEnabled(false);
                    button[i][j+1].setBackground(Color.CYAN);
                }
                if(checkNumbers(i,j+1)== 0){
                    button[i][j+1].setEnabled(false);
                    button[i][j+1].setBackground(Color.CYAN);
                    floodFill(i,j+1);
                }
            }
            else {
                return;
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++
        if (i+1 < 0 || i+1 > 11 || j +1< 0 || j+1 > 11){
            return;
        }
        else if (button[i+1][j+1].getText()==""){
            if(button[i+1][j+1].isEnabled()){

                if(checkNumbers(i+1,j+1)==-1){
                    return;
                }
                if(checkNumbers(i+1,j+1)== 1){
                    int n=numbers.get(button[i+1][j+1]);
                    String s=Integer.toString(n);
                    button[i+1][j+1].setText("q");
                    button[i+1][j+1].setEnabled(false);
                    button[i+1][j+1].setBackground(Color.CYAN);
                }
                if(checkNumbers(i+1,j+1)== 0){
                    button[i+1][j+1].setEnabled(false);
                    button[i+1][j+1].setBackground(Color.CYAN);
                    floodFill(i+1,j+1);
                }
            }
            else {
                return;
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++
        if (i+1 < 0 || i+1 > 11 || j < 0 || j > 11){
            return;
        }
        else if (button[i+1][j].getText()==""){
            if(button[i+1][j].isEnabled()){

                if(checkNumbers(i+1,j)==-1){
                    return;
                }
                if(checkNumbers(i+1,j)== 1){
                    int n=numbers.get(button[i+1][j]);
                    String s=Integer.toString(n);
                    button[i+1][j].setText("r");
                    button[i+1][j].setEnabled(false);
                    button[i+1][j].setBackground(Color.CYAN);
                }
                if(checkNumbers(i+1,j)== 0){
                    button[i+1][j].setEnabled(false);
                    button[i+1][j].setBackground(Color.CYAN);
                    floodFill(i+1,j);
                }
            }
            else {
                return;
            }
        }
        //+++++++++++++++++++++++++++++++++++++++
        if (i+1 < 0 || i+1 > 11 || j -1< 0 || j-1 > 11){
            return;
        }
        else if (button[i+1][j-1].getText()==""){
            if(button[i+1][j-1].isEnabled()){

                if(checkNumbers(i+1,j-1)==-1){
                    return;
                }
                if(checkNumbers(i+1,j-1)== 1){
                    int n=numbers.get(button[i+1][j-1]);
                    String s=Integer.toString(n);
                    button[i+1][j-1].setText("s");
                    button[i+1][j-1].setEnabled(false);
                    button[i+1][j-1].setBackground(Color.CYAN);
                }
                if(checkNumbers(i+1,j-1)== 0) {
                    button[i+1][j-1].setEnabled(false);
                    button[i+1][j-1].setBackground(Color.CYAN);
                    floodFill(i+1,j-1);
                }
            }
            else {
                return;
            }
        }

    }
    public int checkNumbers(int i,int j){
        if (i < 0 || i > 11 || j < 0 || j > 11) {
            return -1;
        }
        if (numbers.containsKey(button[i][j])) {
            return 1;
        }
        return 0;
    }

    public void numFill(int i, int j){
//        button[i][j].setEnabled(false);
        int n=numbers.get(button[i][j]);
        String s=Integer.toString(n);
        button[i][j].setText(s);
        button[i][j].setBackground(Color.lightGray);
    }

    Random random = new Random();
    public void setMines(){
        for (int i=0 ;i<4;i++){
            int x= random.nextInt(12);
            int y=random.nextInt(12);
            mines.add(button[x][y]);


        }
    }
    public void minesLose(){

        for (int i=0 ;i<12;i++){
            for (int j=0 ;j<12;j++){
                button[i][j].setEnabled(false);
                if (numbers.containsKey(button[i][j])){
                    numFill(i,j);
                }
            }
        }

        for (Button b :mines){
            b.setText("💣");
            b.setBackground(new Color(0xCB1515));
            b.setEnabled(true);
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

    public int checkMines(int i,int j){
        if (i < 0 || i > 11 || j < 0 || j > 11) {
            return 0;
        }
        if (mines.contains(button[i][j])) {
            return 1;
        }
        return 0;
    }



}


