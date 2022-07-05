import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


    public class TicTacToe implements ActionListener {

        Random random=new Random();// for randomly select whose turn first
        JFrame frame =new JFrame();
        JPanel titlePanel=new JPanel();// to hold the title
        JPanel buttonPanel =new JPanel();// to hold the button
        JLabel textField =new JLabel();//to display message
        JButton[] buttons=new JButton[9];// we required 9 button
        boolean player1Turn;


        TicTacToe(){
            // creating jframe first
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,650);//size of frame
            frame.getContentPane().setBackground(Color.BLACK);  // set frame backgrount color,we can use rbg value new color(50,50,50);
            frame.setLayout(new BorderLayout());  //to set layout of frame
            frame.setVisible(true);

            // creating text field
            textField.setBackground(new Color(185, 47, 163));    // to set background color of textfield
            textField.setForeground(new Color(82, 71, 204));   // set foreground color of textfield
            textField.setFont(new Font("Ink Free",Font.BOLD,80));   //set font type ,size,bold
            textField.setHorizontalAlignment(JLabel.CENTER);   // to set horizontal allignment take heading at centre
            textField.setText("Tic Tac Toe");  //this will display on heading
            textField.setOpaque(true);

            // now we add this text field to title panel and then we add title panel to frame
            //adding text field to title panel

            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBounds(0,0,900,90);
            //lets add textfield to title pannel and title panel to frame

            buttonPanel.setLayout(new GridLayout(3,3));//3,3 because we have 9 buttons
            buttonPanel.setBackground(new Color(165, 57, 79));// to set background color of button panel

            for(int i=0;i<9;i++){ // with this we will create 9 box of button
                buttons[i]=new JButton();
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font("MV Boli",Font.BOLD,90));// this will show the size and font of x and o
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            }

            titlePanel.add(textField);
            frame.add(titlePanel,BorderLayout.NORTH);//we use borderlayout.North to take heading at top
            frame.add(buttonPanel);//we add button panel to frame


            firstTurn();


        }
        @Override
        public void actionPerformed(ActionEvent e){
            // here on each click on box what will display is set
            for (int i=0;i<9;i++){
                if(e.getSource()==buttons[i]){
                    if (player1Turn==true){
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(255,0,0));
                            buttons[i].setText("X");//it is text on button
                            player1Turn=false;
                            textField.setText("O turn"); // it is text on heading ie textfield
                            check();
                        }
                    }
                    else{
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(0,0,255));
                            buttons[i].setText("O");
                            player1Turn=true;
                            textField.setText("X turn");
                            check();
                        }
                    }
                }
            }

        }

        public void firstTurn(){

            try {
                Thread.sleep(2000);//this is use for to stop program for 2 sec so it can display heading tic tac toe then game start with x or o turns
            }catch (InterruptedException e){ //  in short it allow delay
                e.printStackTrace();
            }

            // we take random number from 0 and 1
            // if it is 0 then it is player one turn
            //if it is 1 then it is player two turn

            if(random.nextInt(2)==0){//here we will take random number from 0 to 1
                player1Turn=true;  // if number is 0 then it is player first turn
                textField.setText("X turn"); // this will display on heading
            }
            else{
                player1Turn=false;//when random number is 1 then it is player two turn
                textField.setText("O turn"); // this will display on heading


            }

        }
        public void check(){
            // to check the winnig combination of x
            if (
                    (buttons[0].getText() == "X") &&
                            (buttons[1].getText() == "X") &&
                            (buttons[2].getText() == "X"))
            {
                xWins(0,1,2);
            }
            if (
                    (buttons[3].getText() == "X") &&
                            (buttons[4].getText() == "X") &&
                            (buttons[5].getText() == "X"))
            {
                xWins(3,4,5);
            }
            if (
                    (buttons[6].getText() == "X") &&
                            (buttons[7].getText() == "X") &&
                            (buttons[8].getText() == "X"))
            {
                xWins(6,7,8);
            }
            if (
                    (buttons[0].getText() == "X") &&
                            (buttons[3].getText() == "X") &&
                            (buttons[6].getText() == "X"))
            {
                xWins(0,3,6);
            }
            if (
                    (buttons[1].getText() == "X") &&
                            (buttons[4].getText() == "X") &&
                            (buttons[7].getText() == "X"))
            {
                xWins(1,4,7);
            }
            if (
                    (buttons[2].getText() == "X") &&
                            (buttons[5].getText() == "X") &&
                            (buttons[8].getText() == "X"))
            {
                xWins(2,5,8);
            }
            if (
                    (buttons[0].getText() == "X") &&
                            (buttons[4].getText() == "X") &&
                            (buttons[8].getText() == "X"))
            {
                xWins(0,4,8);
            }
            if (
                    (buttons[2].getText() == "X") &&
                            (buttons[4].getText() == "X") &&
                            (buttons[6].getText() == "X"))
            {
                xWins(2,4,6);
            }


            // O wins condotion
            if (
                    (buttons[0].getText() == "O") &&
                            (buttons[1].getText() == "O") &&
                            (buttons[2].getText() == "O"))
            {
                oWins(0,1,2);
            }
            if (
                    (buttons[3].getText() == "O") &&
                            (buttons[4].getText() == "O") &&
                            (buttons[5].getText() == "O"))
            {
                oWins(3,4,5);
            }
            if (
                    (buttons[6].getText() == "O") &&
                            (buttons[7].getText() == "O") &&
                            (buttons[8].getText() == "O"))
            {
                oWins(6,7,8);
            }
            if (
                    (buttons[0].getText() == "O") &&
                            (buttons[3].getText() == "O") &&
                            (buttons[6].getText() == "O"))
            {
                oWins(0,3,6);
            }
            if (
                    (buttons[1].getText() == "O") &&
                            (buttons[4].getText() == "O") &&
                            (buttons[7].getText() == "O"))
            {
                oWins(1,4,7);
            }
            if (
                    (buttons[2].getText() == "O") &&
                            (buttons[5].getText() == "O") &&
                            (buttons[8].getText() == "O"))
            {
                oWins(2,5,8);
            }
            if (
                    (buttons[0].getText() == "O") &&
                            (buttons[4].getText() == "O") &&
                            (buttons[8].getText() == "O"))
            {
                oWins(0,4,8);
            }
            if (
                    (buttons[2].getText() == "O") &&
                            (buttons[4].getText() == "O") &&
                            (buttons[6].getText() == "O"))
            {
                oWins(2,4,6);
            }


        }

        public void xWins(int a,int b,int c){
            buttons[a].setBackground(Color.GRAY);
            buttons[b].setBackground(Color.GRAY);
            buttons[c].setBackground(Color.GRAY);

            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textField.setText("X Wins");
        }

        public void oWins(int a,int b,int c){
            buttons[a].setBackground(Color.GRAY);
            buttons[b].setBackground(Color.GRAY);
            buttons[c].setBackground(Color.GRAY);

            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textField.setText("O Wins");

        }



    }


