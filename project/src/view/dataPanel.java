/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.OThread;
import controller.XThread;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;

/**
 *
 * @author dell
 */
public class dataPanel extends JPanel implements ActionListener{
    
    private JButton joinBu;
    private String gameID;
    private String playerName;
    private String started;
    private int playerID;
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static gamePanel gamePanelPage;
    public dataPanel(String gameID, String playerName, String started, int playerID){
        
            service = new TTTWebService_Service();
            proxy = service.getTTTWebServicePort();
            
            GridLayout lay = new GridLayout(0,4);
            lay.setHgap(5);
            lay.setVgap(5);
            this.setLayout(lay);

            setGameID(gameID);
            setPlayerName(playerName);
            setStarted(started);
            setPlayerID(playerID);
            
            joinBu = new JButton("JOIN");
            joinBu.setFont(new Font("",Font.PLAIN, 12));
            joinBu.addActionListener(this);

            JLabel gID = new JLabel(gameID);
            gID.setFont(new Font("",Font.PLAIN, 11));
            JLabel pName = new JLabel(playerName);
            pName.setFont(new Font("",Font.PLAIN, 11));
            JLabel stime = new JLabel(started);
            stime.setFont(new Font("",Font.PLAIN, 11));
            this.add(gID);
            this.add(pName);
            this.add(stime);
            this.add(joinBu);
            this.setBounds(7, 7, 20, 20);
            this.setMaximumSize(new Dimension(500, 400));
    }
    
    public void setGameID(String gameID){
        this.gameID = gameID;
    }
    
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    
    public void setStarted(String started){
        this.started = started;
    }
    
    public void setPlayerID(int playerID){
        this.playerID = playerID;
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        String result = "";
        JButton whichButton = (JButton)(e.getSource());
        String text = whichButton.getText();

        if(text.equals("JOIN")) {
            result = proxy.getGameState(Integer.parseInt(gameID));
            if(result.equals("-1")){
                String resultJoin = proxy.joinGame(playerID, Integer.parseInt(gameID));
                if(resultJoin.equals("1")){
                    gamePanelPage = new gamePanel();
                    gamePanelPage.setTurn("O");
                    gamePanelPage.setLeaveBeginClickable(false);
                    Thread current = new Thread(new XThread(gamePanelPage,Integer.parseInt(gameID), playerID));
                    Thread another = new Thread(new OThread(gamePanelPage,Integer.parseInt(gameID), playerID));

                    current.start();
                    another.start();
                }
                else{
                    System.out.println(resultJoin);
                }
            }
            else
                System.out.println("error");
        }
    }
}
