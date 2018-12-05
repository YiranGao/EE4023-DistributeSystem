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
import view.gamePanel;

/**
 *
 * @author dell
 */
public class XThread implements Runnable{
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static gamePanel gamePanelPage;
    private static int gameID;
    private static int playerID;
    private static int cnt;
    
    public XThread(gamePanel gamePanelPage, int gameID, int playerID){
        this.gamePanelPage = gamePanelPage;
        this.gameID = gameID;
        this.playerID = playerID;
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        addx0y0Listeners();
        addx1y0Listeners();
        addx2y0Listeners();
        addx0y1Listeners();
        addx1y1Listeners();
        addx2y1Listeners();
        addx0y2Listeners();
        addx1y2Listeners();
        addx2y2Listeners();
    }
    
     @Override
    public void run() {
        while (numberOfMoves() < 9) {
            synchronized (gamePanelPage) {
            if(numberOfMoves() > 1){
                String result = proxy.checkWin(gameID);
                if(result.equals("1")){
                    gamePanelPage.setButtonUnclickable();
                    gamePanelPage.setFinish("Player 1 Win   ");
                    String res = proxy.setGameState(gameID, 1);
                    if(res.equals("1")){
                        break;
                    }
                    else{
                        System.out.println(result);
                    }
                }
                else if(result.equals("2")){
                    gamePanelPage.setButtonUnclickable();
                    gamePanelPage.setFinish("Player 2 Win   ");
                    String res = proxy.setGameState(gameID, 2);
                    if(res.equals("1")){
                        break;
                    }
                    else{
                        System.out.println(result);
                    }
                }
                else if(result.equals("3")){
                    gamePanelPage.setButtonUnclickable();
                    gamePanelPage.setFinish("Draw   ");
                    String res = proxy.setGameState(gameID, 3);
                    if(res.equals("1")){
                        break;
                    }
                    else{
                        System.out.println(result);
                    }
                }
                else if(result.equals("0")){
                    String res = proxy.setGameState(gameID, 0);
                    if(!res.equals("1")){
                        System.out.println(result);
                    }
                }
                else
                        System.out.println(result);
            }
                gamePanelPage.setButtonClickable();
                if (gamePanelPage.getTurn().equals("O")) {
                    try {
                        gamePanelPage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    cnt = 0;
                    while(cnt == 0){
                        gamePanelPage.setTurn("X");
                    }
                    
                    gamePanelPage.setTurn("O");
                    gamePanelPage.notify();
                }
            }
        }
    }
    
    public int numberOfMoves(){
        int count = 0;
        String result = proxy.getBoard(gameID);
        String [] moves = result.split("\n");
        count = moves.length;
        return count;
    }
    
    
    public static void addx0y0Listeners(){
        gamePanelPage.addx0y0Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(0, 0, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(0, 0);
                    gamePanelPage.setHasMoved(0, 0);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
     
    public static void addx1y0Listeners(){
        gamePanelPage.addx1y0Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(1, 0, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(1,0);
                    gamePanelPage.setHasMoved(1, 0);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
      
    public static void addx2y0Listeners(){
        gamePanelPage.addx2y0Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(2, 0, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(2, 0);
                    gamePanelPage.setHasMoved(2, 0);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
    public static void addx0y1Listeners(){
        gamePanelPage.addx0y1Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(0, 1, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(0, 1);
                    gamePanelPage.setHasMoved(0, 1);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
     
    public static void addx1y1Listeners(){
        gamePanelPage.addx1y1Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(1, 1, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(1, 1);
                    gamePanelPage.setHasMoved(1, 1);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
      
    public static void addx2y1Listeners(){
        gamePanelPage.addx2y1Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(2, 1, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(2, 1);
                    gamePanelPage.setHasMoved(2, 1);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }public static void addx0y2Listeners(){
        gamePanelPage.addx0y2Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(0, 2, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(0, 2);
                    gamePanelPage.setHasMoved(0, 2);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
     
    public static void addx1y2Listeners(){
        gamePanelPage.addx1y2Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(1, 2, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(1, 2);
                    gamePanelPage.setHasMoved(1, 2);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
      
    public static void addx2y2Listeners(){
        gamePanelPage.addx2y2Listener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String result = proxy.takeSquare(2, 2, gameID, playerID);
                if(result.equals("1")){
                    gamePanelPage.setSquareX(2, 2);
                    gamePanelPage.setHasMoved(2, 2);
                    gamePanelPage.setTurn("X");
                    cnt++;
                }
            }});
    }
}
