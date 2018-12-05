/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
import view.TicTacToeScreen;
import view.loginUI;

/**
 *
 * @author XintingLi
 */
public class login {
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static loginUI loginPage;
    private static TicTacToeScreen mainFrame;
    
    public login(loginUI loginPage, TicTacToeScreen mainFrame){
        this.loginPage = loginPage;
        this.mainFrame = mainFrame;
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        
        addLoginListeners_Login();
    }
    
    public static void addLoginListeners_Login(){
        loginPage.addLoginListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int result = loginUser();
                String playerName = loginPage.getUsername();
                boolean returnVa = checkSuccessful(result);
                if(returnVa){
                    mainScreen mainScreenBL = new mainScreen(result, playerName);

                    mainFrame.getLoginPage().setVisible(false);
                    mainFrame.getLoginPage().setEnabled(false);  
                    mainFrame.setVisible(false);
                }
            }});
    }
    
    public static int loginUser(){
        
        String username = loginPage.getUsername();
        String password = loginPage.getPassword();
        int result = proxy.login(username, password);
        return result;
    }
    
    public static boolean checkSuccessful(int result){
        
        boolean returnVa = loginPage.returnResult(result);
        return returnVa;
    }
    
}
