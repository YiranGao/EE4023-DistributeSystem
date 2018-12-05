/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
import view.gamePanel;

/**
 *
 * @author dell
 */
public class OThread implements Runnable{
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static gamePanel gamePanelPage;
    private static int gameID;
    private static int playerID;
    
    public OThread(gamePanel gamePanelPage, int gameID, int playerID){
        this.gamePanelPage = gamePanelPage;
        this.gameID = gameID;
        this.playerID = playerID;
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
    }
    
    @Override
    public void run() {
        while (numberOfMoves() < 9) {
            synchronized (gamePanelPage) {
            if(numberOfMoves() > 2){
                String result = proxy.checkWin(gameID);
                
                if(result.equals("1")){
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
                if (gamePanelPage.getTurn().equals("X")) {
                    try {
                        gamePanelPage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } 
                else {
                    gamePanelPage.setButtonUnclickable();
                    String lastUser = String.valueOf(playerID);
                    String [] details = new String[3];
                    while(lastUser.equals(String.valueOf(playerID))){
                        String lastMove = getLastMove();
                        if(!(lastMove.equals("ERROR-NOMOVES") || lastMove.equals("ERROR-DB"))){
                            lastMove = lastMove.replace("{", "");
                            lastMove = lastMove.replace("}", "");
                            details = lastMove.split(",");
                            lastUser = details[0];
                        }
                    }    
                    gamePanelPage.setSquareO(Integer.parseInt(details[1]), Integer.parseInt(details[2]));
                    gamePanelPage.setHasMoved(Integer.parseInt(details[1]), Integer.parseInt(details[2]));

                    gamePanelPage.setTurn("X");
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
    
    public String getLastMove(){
        String result = proxy.getBoard(gameID);
        String [] moves = result.split("\n");
        return moves[moves.length - 1];
    }
}
