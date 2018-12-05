/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.player;

/**
 *
 * @author dell
 */
public class ScoreSystemUI extends JFrame{
    private JLabel heading;
    private JLabel nameLabel;
    private JLabel winsLabel;
    private JLabel lossesLabel;
    private JLabel drawsLabel;
    private static JLabel playerName;
    private static JLabel playerWins;
    private static JLabel playerLosses;
    private static JLabel playerDraws;
    public ScoreSystemUI(player thisPlayer){
        JPanel mainContent = new JPanel();
        
        heading = new JLabel("Score System", JLabel.CENTER);
        nameLabel = new JLabel("Player name:");
        winsLabel = new JLabel("Wins:");
        lossesLabel = new JLabel("Losses:");
        drawsLabel = new JLabel("Draws:");
        playerName = new JLabel();
        playerWins = new JLabel();
        playerLosses = new JLabel();
        playerDraws = new JLabel();
        
        if(thisPlayer != null){
            playerName.setText(thisPlayer.getPlayerName());
            playerWins.setText(String.valueOf(thisPlayer.getWins()));
            playerLosses.setText(String.valueOf(thisPlayer.getLosses()));
            playerDraws.setText(String.valueOf(thisPlayer.getDraws()));
        }
        
        heading.setFont(new Font("", Font.PLAIN, 60));
        nameLabel.setFont(new Font("", Font.PLAIN, 25));
        winsLabel.setFont(new Font("", Font.PLAIN, 25));
        lossesLabel.setFont(new Font("", Font.PLAIN, 25));
        drawsLabel.setFont(new Font("", Font.PLAIN, 25));
        playerName.setFont(new Font("", Font.PLAIN, 25));
        playerWins.setFont(new Font("", Font.PLAIN, 25));
        playerLosses .setFont(new Font("", Font.PLAIN, 25));
        playerDraws.setFont(new Font("", Font.PLAIN, 25));
        mainContent.add(heading, BorderLayout.NORTH);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0,2,50,50));
        infoPanel.setBorder(new EmptyBorder(100, 300, 50, 300));
        infoPanel.add(nameLabel);
        infoPanel.add(playerName);
        infoPanel.add(winsLabel);
        infoPanel.add(playerWins);
        infoPanel.add(lossesLabel);
        infoPanel.add(playerLosses);
        infoPanel.add(drawsLabel);
        infoPanel.add(playerDraws);
        mainContent.add(infoPanel, BorderLayout.CENTER);
        
        this.setContentPane(mainContent);
        this.setSize(900,600);
        this.setResizable(false);
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setVisible(true);
    }
}
