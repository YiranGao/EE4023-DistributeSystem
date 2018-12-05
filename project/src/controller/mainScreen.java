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
import view.gamePanel;
import view.mainScreenUI;

/**
 *
 * @author dell
 */
public class mainScreen {
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static mainScreenUI mainScreenPage;
    private static gamePanel gamePage;
    private static statistics statisticsBL;
    private String playerName;
    private int gameID;
    private int playerID;
    
    public mainScreen(int playerID, String playerName){
        mainScreenPage = new mainScreenUI(playerName, playerID);
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        this.playerName = playerName;
        this.playerID = playerID;
        
        addNewGameListeners();
        addStatisticsListeners();
        addScoreSystemListeners();
    }

    private void addNewGameListeners() {
        mainScreenPage.addNewGameListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.newGame(playerID);
                if(!(result.equals("ERROR-NOTFOUND") || result.equals("ERROR-RETRIEVE") || result.equals("ERROR-INSERT") || result.equals("ERROR-DB"))){
                    gameID = Integer.parseInt(result);
                    newGame game = new newGame(playerID, gameID);
                }
                else{
                    System.out.println(result);
                }   
            }});
    }
    
    private void addStatisticsListeners() {
        mainScreenPage.addStatisticsListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                statisticsBL = new statistics(playerName);
                statisticsBL.setData();
                statisticsBL.showStatistic();
                              
            }});
    }
    
    private void addScoreSystemListeners() {
        mainScreenPage.addScoreSystemListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                statisticsBL = new statistics(playerName);
                statisticsBL.setData();
                statisticsBL.getScoreSystem(playerName);
            }});
    }
    
}
