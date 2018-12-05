/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author XintingLi
 */
public class TicTacToeScreen extends JFrame{
    
    private static welcomePageUI welcomePage;
    private static loginUI loginPage;
    private static registerUI registerPage;
    private static TicTacToeScreen mainFrame;
    
    public TicTacToeScreen(){

        mainFrame = this;
        welcomePage = new welcomePageUI(mainFrame);
        loginPage = new loginUI(mainFrame);
        registerPage = new registerUI(mainFrame);
        
        loginPage.setBounds(0, 0, 900, 600);
        this.add(loginPage);
        registerPage.setBounds(0, 0, 900, 600);
        this.add(registerPage);
        welcomePage.setBounds(0, 0, 900, 600);
        this.add(welcomePage);

        welcomePage.setEnabled(true);
        welcomePage.setVisible(true);
        
        this.setSize(900,600);
        this.setResizable(false);
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static loginUI getLoginPage(){
        return loginPage;
    }
    
    public static welcomePageUI getWelcomePage(){
        return welcomePage;
    }
    
    public static registerUI getRegisterPage(){
        return registerPage;
    }
   
    public static TicTacToeScreen getMainFrame(){
        return mainFrame;
    }

}
