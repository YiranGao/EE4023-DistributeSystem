/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.newGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author dell
 */
public class gamePanel extends JFrame{
    
    private static JPanel mainContent;
    private static JButton[][] square;
    private static JLabel turn;
    private static String state;
    private static JButton leave;
    private static JButton begin;
    private static JPanel mainButtonPanel;
    private static JPanel gamePanel;
    private static int[][] hasMoved;
    private static JLabel finish;
    private static JPanel labelPanel;
    
    public gamePanel(){
        state = "X";
        mainContent = new JPanel();
        labelPanel = new JPanel();
        square = new JButton[3][3];
        hasMoved = new int[3][3];
        turn = new JLabel(" ", JLabel.CENTER);
        finish = new JLabel(" ", JLabel.CENTER);
        turn.setFont(new Font("",Font.PLAIN, 40));
        finish.setFont(new Font("",Font.PLAIN, 40));
        labelPanel.setLayout(new GridLayout(0,1));
        labelPanel.add(turn);
        labelPanel.add(finish);
        
        gamePanel = new JPanel();
        leave = new JButton("LEAVE");
        leave.setFont(new Font("",Font.PLAIN, 20));
        begin = new JButton("BEGIN");
        begin.setFont(new Font("",Font.PLAIN, 20));
        
        gamePanel.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                square[i][j] = new JButton();
                square[i][j].setFont(new Font("",Font.PLAIN, 50));
                hasMoved[i][j] = 0;
                gamePanel.add(square[i][j]);
            }
        }
        gamePanel.setPreferredSize(new Dimension(500, 500));
        
        mainContent.add(labelPanel, BorderLayout.WEST);
        mainContent.add(gamePanel, BorderLayout.CENTER);
        
        mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new GridLayout(0,1));
        mainButtonPanel.setBorder(new EmptyBorder(250, 10, 50, 20));
        mainButtonPanel.add(leave);
        mainButtonPanel.add(begin);
        mainContent.add(mainButtonPanel, BorderLayout.EAST);
        
        this.add(mainContent);
        this.setSize(900,600);
        this.setResizable(false);
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }
    
    public static void addLeaveListener(ActionListener a){
        leave.addActionListener(a);
    }
    
    public static void addBeginListener(ActionListener a){
        begin.addActionListener(a);
    }
     
    public static void addx0y0Listener(ActionListener a){
        square[0][0].addActionListener(a);
    }
     
    public static void addx1y0Listener(ActionListener a){
        square[1][0].addActionListener(a);
    }
      
    public static void addx2y0Listener(ActionListener a){
        square[2][0].addActionListener(a);
    }
    
    public static void addx0y1Listener(ActionListener a){
        square[0][1].addActionListener(a);
    }
     
    public static void addx1y1Listener(ActionListener a){
        square[1][1].addActionListener(a);
    }
      
    public static void addx2y1Listener(ActionListener a){
        square[2][1].addActionListener(a);
    }
    public static void addx0y2Listener(ActionListener a){
        square[0][2].addActionListener(a);
    }
     
    public static void addx1y2Listener(ActionListener a){
        square[1][2].addActionListener(a);
    }
      
    public static void addx2y2Listener(ActionListener a){
        square[2][2].addActionListener(a);
    }
    
    public static void setSquareO(int x, int y)
    {
        square[x][y].setText("O");
    }
    
    public static void setSquareX(int x, int y)
    {
        square[x][y].setText("X");
    }
    
    public static void setHasMoved(int x, int y){
        square[x][y].setEnabled(false);
        hasMoved[x][y] = 1;
    }
    
    public static void setLeaveBeginClickable(boolean flag){
        leave.setEnabled(flag);
        begin.setEnabled(flag);
    }
    
    public static String getTurn(){
        return state;
    } 
    
    public static void setTurn(String player){
        state = player;
        turn.setText(player + " Turn   ");
    }
    
    public static void setButtonUnclickable(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                square[i][j].setEnabled(false);
            }
        }
    }
    
     public static void setButtonClickable(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(hasMoved[i][j] == 0)
                    square[i][j].setEnabled(true);
            }
        }
    }
     
     public static void setFinish(String result){
         finish.setText(result);
     }
}
