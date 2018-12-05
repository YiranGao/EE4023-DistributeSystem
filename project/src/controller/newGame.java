/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
import view.TicTacToeScreen;
import view.gamePanel;

/**
 *
 * @author dell
 */
public class newGame {
    
    private static gamePanel gamePanelPage;
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static int gameID;
    private static int playerID;
    private static checkJoined checkThread;
    
    public newGame(int playerID, int gameID){
        gamePanelPage = new gamePanel();
        addLeaveListeners();
        addBeginListeners();
        this.playerID = playerID;
        this.gameID = gameID;
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        
        checkThread = new checkJoined(gameID, playerID);
        checkThread.start();

    }
    
    private void addLeaveListeners() {
        gamePanelPage.addLeaveListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gamePanelPage.dispose();
                checkThread.setThreadState();
                String result = proxy.deleteGame(gameID, playerID);
            }});
    }
    
    private void addBeginListeners() {
        gamePanelPage.addBeginListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(proxy.getGameState(gameID).equals("0"))
                {
                    gamePanelPage.setTurn("X");
                    gamePanelPage.setLeaveBeginClickable(false);
                    Thread current = new Thread(new XThread(gamePanelPage,gameID, playerID));
                    Thread another = new Thread(new OThread(gamePanelPage,gameID, playerID));

                    current.start();
                    another.start();
                }
            }});
    }
       
}
