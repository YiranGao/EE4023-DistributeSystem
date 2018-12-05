/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
import view.gamePanel;

/**
 *
 * @author dell
 */
public class checkJoined extends Thread{
    private String result;
    private static int gameID;
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static boolean state;
    private static int playerID;
    
    public checkJoined(int gameID, int playerID) {
        this.gameID = gameID;
        this.playerID = playerID;
        result = "-1";
        state = false;
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();

    }
    
    private String getGameState() {
        result = proxy.getGameState(gameID);
        if(result.equals("-1") || result.equals("0") || result.equals("1") || result.equals("2") || result.equals("3")){
            return result;
        }
        else{
            System.out.println(result);
            result = "";
            return result;
        }
    }
    
    @Override
    public void run() {
        while(result.equals("-1") && state == false) {
            result = getGameState();
            try {
                sleep(1000);
            } catch(Exception e) {
                
            }
        }
        if(result.equals("0"))
            JOptionPane.showMessageDialog(null, "Someone Joined");
    }
    
    public void setThreadState(){
        state = true;
    }
   
}
