import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    int count = 0;

    TicTacToe(){
        //Set up the frame that will pop up along with color and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(255,175,175));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //We created a text box so we assign text, color, font, and background
        textfield.setBackground(new Color (175,175,255));
        textfield.setForeground(new Color(225,0,225));
        textfield.setFont(new Font ("Ink Free", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        //We chose where the title panel will go on the screen
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        //fixing/creating our buttons
        for (int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //We are setting our text field to our title panel and then the title panel to our frame
        title_panel.add(textfield);
        // second parameter allows us to put the border on the top of the frame instead of taking up the whole frame
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<9; i++){
            if (e.getSource() == buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,255,255));
                        buttons[i].setText("X");
                        player1_turn = false;
                        count++;
                        textfield.setText("O Turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X Turn");
                        count++;
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){
    count++;
        if(random.nextInt(2) == 0){
            player1_turn = true;
            textfield.setText("X turn");
            
        }else{
            player1_turn = false;
            textfield.setText("O turn");
            
        }
    }

    public void check(){
        tie();
        //Check X win condition
        if((buttons[0].getText() == "X") && 
        (buttons[1].getText() == "X") && 
        (buttons[2].getText() == "X")){
            xWins(0, 1, 2);
        }
        if((buttons[3].getText() == "X") && 
        (buttons[4].getText() == "X") && 
        (buttons[5].getText() == "X")){
            xWins(3, 4, 5);
        }
        if((buttons[6].getText() == "X") && 
        (buttons[7].getText() == "X") && 
        (buttons[8].getText() == "X")){
            xWins(6, 7, 8);
        }
        if((buttons[0].getText() == "X") && 
        (buttons[3].getText() == "X") && 
        (buttons[6].getText() == "X")){
            xWins(0, 3, 6);
        }
        if((buttons[1].getText() == "X") && 
        (buttons[4].getText() == "X") && 
        (buttons[7].getText() == "X")){
            xWins(1, 4, 7);
        }
        if((buttons[2].getText() == "X") && 
        (buttons[5].getText() == "X") && 
        (buttons[8].getText() == "X")){
            xWins(2, 5, 8);
        }
        if((buttons[0].getText() == "X") && 
        (buttons[4].getText() == "X") && 
        (buttons[8].getText() == "X")){
            xWins(0, 4,8);
        }
        if((buttons[2].getText() == "X") && 
        (buttons[4].getText() == "X") && 
        (buttons[6].getText() == "X")){
            xWins(2, 4, 6);
        }


        //Check O win condition
        if((buttons[0].getText() == "O") && 
        (buttons[1].getText() == "O") && 
        (buttons[1].getText() == "O")){
            oWins(0, 1, 2);
        }
        if((buttons[3].getText() == "O") && 
        (buttons[4].getText() == "O") && 
        (buttons[5].getText() == "O")){
            oWins(3, 4, 5);
        }
        if((buttons[6].getText() == "O") && 
        (buttons[7].getText() == "O") && 
        (buttons[8].getText() == "O")){
            oWins(6, 7, 8);
        }
        if((buttons[0].getText() == "O") && 
        (buttons[3].getText() == "O") && 
        (buttons[6].getText() == "O")){
            oWins(0, 3, 6);
        }
        if((buttons[1].getText() == "O") && 
        (buttons[4].getText() == "O") && 
        (buttons[7].getText() == "O")){
            oWins(1, 4, 7);
        }
        if((buttons[2].getText() == "O") && 
        (buttons[5].getText() == "O") && 
        (buttons[8].getText() == "O")){
            oWins(2, 5, 8);
        }
        if((buttons[0].getText() == "O") && 
        (buttons[4].getText() == "O") && 
        (buttons[8].getText() == "O")){
            oWins(0, 4,8);
        }
        if((buttons[2].getText() == "O") && 
        (buttons[4].getText() == "O") && 
        (buttons[6].getText() == "O")){
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c){
        //Makes the winning line of X's a different color
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        //makes sure no one can keep playing
        for (int i =0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
    }

    public void oWins(int a, int b, int c){
        //Makes the winning line of X's a different color
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        //makes sure no one can keep playing
        for (int i =0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }

    public void tie(){
        if (count == 10){
            textfield.setText("Tie");
            for (int i=0;i<9;i++){
                buttons[i].setBackground(Color.RED);
                buttons[i].setEnabled(false);
            }
        }
   
}
}
