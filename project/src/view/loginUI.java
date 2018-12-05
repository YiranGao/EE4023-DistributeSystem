/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.login;

/**
 *
 * @author XintingLi
 */
public class loginUI extends JPanel{
    
    private JLabel heading;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private static JTextField usernameField;
    private static JTextField passwordField;
    private static JLabel resultLable;
    private static JButton loginBu;
    private static TicTacToeScreen mainFrame;
    private static loginUI loginPage;
    
    public loginUI(TicTacToeScreen mainFrame){
        loginPage = this;
        this.mainFrame = mainFrame;
        heading = new JLabel("Login", JLabel.CENTER);
        loginBu = new JButton("Login");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JTextField();
        resultLable = new JLabel();
     
        this.setLayout(new BorderLayout());
        heading.setFont(new Font("",Font.PLAIN, 60));
        loginBu.setFont(new Font("",Font.PLAIN, 25));
        usernameLabel.setFont(new Font("", Font.PLAIN, 25));
        passwordLabel.setFont(new Font("", Font.PLAIN, 25));
        usernameField.setFont(new Font("", Font.PLAIN, 25));
        passwordField.setFont(new Font("", Font.PLAIN, 25));
        resultLable.setFont(new Font("", Font.PLAIN, 25));
        this.add(heading, BorderLayout.NORTH);
   
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBorder(new EmptyBorder(50, 200, 100, 200));
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1, 50, 50));
        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);
        
        JPanel TFPanel = new JPanel();
        TFPanel.setLayout(new GridLayout(2, 1, 50, 50));
        TFPanel.add(usernameField);
        TFPanel.add(passwordField);
        
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.X_AXIS));
        detailPanel.add(labelPanel);
        detailPanel.add(TFPanel);
        
        registerPanel.add(detailPanel);
        
        JPanel resultPanel = new JPanel(new GridLayout(0,1, 10, 10));
        resultPanel.add(resultLable); 
        registerPanel.add(resultPanel);
        resultLable.setVisible(false);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginBu);
        registerPanel.add(buttonPanel);
        
        this.add(registerPanel, BorderLayout.CENTER);
        login loginBL = new login(loginPage, mainFrame);
        
        this.setEnabled(false);
        this.setVisible(false);

    }
    
    public static TicTacToeScreen getMainFrame(){
        return mainFrame;
    }
    
    public loginUI getLoginPage(){
        return loginPage;
    }
    
    public static void addLoginListener(ActionListener a){
        loginBu.addActionListener(a);
    }
    
    public static String getUsername()
    {
        return usernameField.getText();
    }
    
    public static String getPassword()
    {
        return passwordField.getText();
    }
    
    public boolean returnResult(int result){
        
        if(result <= 0){
            resultLable.setText("Incorrect username or password.");
            resultLable.setVisible(true);
            return false;
        }
        else{
            resultLable.setText("successful");
            resultLable.setVisible(true);
            return true;
        }
    }
}
