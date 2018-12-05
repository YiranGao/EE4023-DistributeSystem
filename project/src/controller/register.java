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
import view.registerUI;

/**
 *
 * @author dell
 */
public class register {
    
    private static registerUI registerPage;
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static TicTacToeScreen mainFrame;
    
    public register(registerUI registerPage, TicTacToeScreen mainFrame){
        
        this.registerPage = registerPage;
        this.mainFrame = mainFrame;
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        addRegisterListeners_register();
        
    }
    
    public static void addRegisterListeners_register(){
        registerPage.addRegisterListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String result = registerUser();
                String playerName = registerPage.getUsername();
                boolean returnVa = checkSuccessful(result);
                if(returnVa){
                    int id = Integer.parseInt(result);
                    mainScreen mainScreenBL = new mainScreen(id, playerName);
                    mainFrame.getRegisterPage().setVisible(false);
                    mainFrame.getRegisterPage().setEnabled(false);
                    mainFrame.setVisible(false);
                }
            }});
    }
     
    public static String registerUser(){
        
        String username = registerPage.getUsername();
        String password = registerPage.getPassword();
        String name = registerPage.getFirstname();
        String surname = registerPage.getSurname();
        String result = proxy.register(username, password, name, surname);
        
        return result;
    }
    
    public static boolean checkSuccessful(String result){
        
        boolean returnVa = registerPage.returnResult(result);
        return returnVa;
    }
    
}
