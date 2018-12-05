/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.welcome;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author dell
 */
public class welcomePageUI extends JPanel{
    
    private static TicTacToeScreen mainFrame;
    private static JLabel heading;
    private static JButton registerBu;
    private static JButton loginBu;
    private static welcomePageUI welcomePage;
    
    public welcomePageUI(TicTacToeScreen mainFrame){
        
        this.mainFrame = mainFrame;
        welcomePage = this;
        registerBu = new JButton("Register");
        loginBu = new JButton("Login");
        heading = new JLabel("Tic-Tac-Toe", JLabel.CENTER);
        this.setLayout(new BorderLayout());
        heading.setFont(new Font("",Font.PLAIN, 60));
        loginBu.setFont(new Font("",Font.PLAIN, 25));
        registerBu.setFont(new Font("",Font.PLAIN, 25));
        this.add(heading, BorderLayout.NORTH);
        
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new GridLayout(0,1,50,50));
        mainButtonPanel.setBorder(new EmptyBorder(170, 300, 170, 300));
        mainButtonPanel.add(loginBu);
        mainButtonPanel.add(registerBu);
        this.add(mainButtonPanel, BorderLayout.CENTER);
        
        welcome welcomeBL = new welcome(welcomePage, mainFrame);
        
        this.setEnabled(false);
        this.setVisible(true);
                
        
    }
    
    public static void addLoginListener(ActionListener a){
        loginBu.addActionListener(a);
    }
     
    public static void addRegisterListener(ActionListener a){
        registerBu.addActionListener(a);
    }
    
    public static TicTacToeScreen getMainFrame(){
        return mainFrame;
    }
}
