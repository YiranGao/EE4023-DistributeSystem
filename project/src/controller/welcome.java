/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TicTacToeScreen;
import view.welcomePageUI;

/**
 *
 * @author dell
 */
public class welcome {
    private static welcomePageUI welcomePage;
    private static TicTacToeScreen mainFrame;
    
    public welcome(welcomePageUI welcomePage, TicTacToeScreen mainFrame){
        this.welcomePage = welcomePage;
        this.mainFrame = mainFrame;
        addRegisterListeners_mainScreen();
        addLoginListeners_mainScreen();
    }
    
     public static void addRegisterListeners_mainScreen(){
        welcomePage.addRegisterListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.getWelcomePage().setEnabled(false);
                mainFrame.getWelcomePage().setVisible(false);
            
                mainFrame.getRegisterPage().setVisible(true);
                mainFrame.getRegisterPage().setEnabled(true);
            }});
    }
    
     public static void addLoginListeners_mainScreen(){
        welcomePage.addLoginListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.getWelcomePage().setEnabled(false);
                mainFrame.getWelcomePage().setVisible(false);
            
                mainFrame.getLoginPage().setVisible(true);
                mainFrame.getLoginPage().setEnabled(true);
                
            }});
    }
   
}
