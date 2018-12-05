/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.mainScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;

/**
 *
 * @author dell
 */
public class mainScreenUI extends JFrame{
    private static JPanel mainContent;
    private static JLabel heading;
    private static JButton scoreSystem;
    private static JButton statistics;
    private static JButton  newGame;
    private static JTable table;
    private static mainScreenUI mainScreenPage;
    private static String playerName;
    private static JScrollPane jScrollPane;
    private static JPanel innerFrame; 
    private static int playerID;
    
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    
    public mainScreenUI(String playerName, int playerID) {
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        this.playerID = playerID;
        mainScreenPage = this;
        this.playerName = playerName;
        
        mainContent = new JPanel();
        scoreSystem = new JButton("Score System");
        statistics = new JButton("Statistics");
        newGame = new JButton("New Game");
        
        heading = new JLabel("Tic-Tac-Toe", JLabel.CENTER);
        mainContent.setLayout(new BorderLayout());
        heading.setFont(new Font("",Font.PLAIN, 60));
        scoreSystem.setFont(new Font("",Font.PLAIN, 25));
        statistics.setFont(new Font("",Font.PLAIN, 25));
        newGame.setFont(new Font("",Font.PLAIN, 25));
        mainContent.add(heading, BorderLayout.NORTH);
        
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new GridLayout(0,1,50,30));
        mainButtonPanel.setBorder(new EmptyBorder(250, 10, 50, 50));
        mainButtonPanel.add(scoreSystem);
        mainButtonPanel.add(statistics);
        mainButtonPanel.add(newGame);
        mainContent.add(mainButtonPanel, BorderLayout.EAST);
        

        
        innerFrame = new JPanel();
        innerFrame.setLayout(new BoxLayout(innerFrame,BoxLayout.PAGE_AXIS));
        innerFrame.setMaximumSize(new Dimension(500, 400));
        jScrollPane = new JScrollPane(innerFrame);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setPreferredSize(new Dimension(500, 400));
        jScrollPane.setBounds(7, 7, 55, 50);
        
        String result = proxy.showOpenGames();
        
        if(!result.equals("ERROR-NOGAMES") && !result.equals("ERROR-DB")){
            String [] array = result.split("\n");
            for(int i = 0; i < array.length; i++){
                String[] details = array[i].split(",");
                dataPanel example = new dataPanel(
                        details[0],
                        details[1],
                        details[2],
                        playerID);
                innerFrame.add(example);
            }
        }
        else{
            System.out.println(result);
        }
        
        JPanel JtabelPanel = new JPanel();
        JtabelPanel.add(jScrollPane);
        JtabelPanel.setBorder(new EmptyBorder(20, 10, 50, 20));
        mainContent.add(JtabelPanel, BorderLayout.CENTER);
        
       updateData();

        this.add(mainContent);
        this.setSize(900,600);
        this.setResizable(false);
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        
    }
    
    
    public static void addNewGameListener(ActionListener a){
        newGame.addActionListener(a);
    }
    
    public static void addStatisticsListener(ActionListener a){
        statistics.addActionListener(a);
    }
    
    public static void addScoreSystemListener(ActionListener a){
        scoreSystem.addActionListener(a);
    }
    
    public static void updateData(){
        Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    innerFrame.removeAll();
                    innerFrame.repaint();
                    String result = proxy.showOpenGames();
                    if(!result.equals("ERROR-NOGAMES") && !result.equals("ERROR-DB")){
                        String [] array = result.split("\n");
                        for(int i = 0; i < array.length; i++){
                            String[] details = array[i].split(",");
                            dataPanel example = new dataPanel(
                                details[0],
                                details[1],
                                details[2],
                                playerID);
                            innerFrame.add(example);
                        }
                        innerFrame.revalidate();
                    }
                }
            });
            timer.setRepeats(true);
            timer.start();
    }
}
