/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.register;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

/**
 *
 * @author XintingLi
 */
public class registerUI extends JPanel{
    
    private JLabel heading;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private static JTextField usernameField;
    private static JTextField passwordField;
    private static  JTextField nameField;
    private static JTextField surnameField;
    private static JLabel resultLable;
    private static JButton registerBu;
    private static TicTacToeScreen mainFrame;
    private static registerUI registerPage;
    
    public registerUI(TicTacToeScreen mainFrame){
        registerPage = this;
        this.mainFrame = mainFrame;
        heading = new JLabel("Register", JLabel.CENTER);
        registerBu = new JButton("Register");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        nameLabel = new JLabel("Name:");
        surnameLabel = new JLabel("Surname:");
        usernameField = new JTextField();
        passwordField = new JTextField();
        nameField = new JTextField();
        surnameField = new JTextField();
        resultLable = new JLabel();
     
        this.setLayout(new BorderLayout());
        heading.setFont(new Font("", Font.PLAIN, 60));
        registerBu.setFont(new Font("", Font.PLAIN, 25));
        usernameLabel.setFont(new Font("", Font.PLAIN, 25));
        surnameLabel.setFont(new Font("", Font.PLAIN, 25));
        nameLabel.setFont(new Font("", Font.PLAIN, 25));
        passwordLabel.setFont(new Font("", Font.PLAIN, 25));
        usernameField.setFont(new Font("", Font.PLAIN, 25));
        passwordField.setFont(new Font("", Font.PLAIN, 25));
        nameField.setFont(new Font("", Font.PLAIN, 25));
        surnameField.setFont(new Font("", Font.PLAIN, 25));
        resultLable.setFont(new Font("", Font.PLAIN, 25));
        this.add(heading, BorderLayout.NORTH);
   
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBorder(new EmptyBorder(50, 200, 100, 200));
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(4, 1, 50, 50));
        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);
        labelPanel.add(nameLabel);
        labelPanel.add(surnameLabel);
        
        JPanel TFPanel = new JPanel();
        TFPanel.setLayout(new GridLayout(4, 1, 50, 30));
        TFPanel.add(usernameField);
        TFPanel.add(passwordField);
        TFPanel.add(nameField);
        TFPanel.add(surnameField);
        
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.X_AXIS));
        detailPanel.add(labelPanel);
        detailPanel.add(TFPanel);
        
        registerPanel.add(detailPanel);
        
        JPanel resultPanel = new JPanel(new GridLayout(0,1));
        resultPanel.add(resultLable); 
        registerPanel.add(resultPanel);
        resultLable.setVisible(false);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(registerBu);
        registerPanel.add(buttonPanel);
        
        this.add(registerPanel, BorderLayout.CENTER);
        
        register registerBL = new register(registerPage, mainFrame);
 
        this.setEnabled(false);
        this.setVisible(false);
        
    }
    
    public static void addRegisterListener(ActionListener a){
        registerBu.addActionListener(a);
    }
   
    public static String getUsername()
    {
        return usernameField.getText();
    }
    
    public static String getPassword()
    {
        return passwordField.getText();
    }
    
    public static String getFirstname()
    {
        return nameField.getText();
    }
    
    public static String getSurname()
    {
        return surnameField.getText();
    }
    
    public boolean returnResult(String result){
        
        if(result.equals("ERROR-REPEAT")){
            resultLable.setText("username already exists");
            resultLable.setVisible(true);
            return false;
        }
        else if(result.equals("ERROR-INSERT") || result.equals("ERROR-RETRIEVE") || result.equals("ERROR-DB")){
            resultLable.setText("database error");
            resultLable.setVisible(true);
            return false;
        }
        else{
            resultLable.setText("successful");
            resultLable.setVisible(true);
            return true;
        }
    }
    
    public static TicTacToeScreen getMainFrame(){
        return mainFrame;
    }
}
