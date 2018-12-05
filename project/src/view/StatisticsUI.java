/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.player;

/**
 *
 * @author dell
 */
public class StatisticsUI extends JFrame{
    
    private static JPanel panel;
    private ArrayList<player> list;
    private Object[][] rowData;
    public StatisticsUI(ArrayList<player> list){
        panel = new JPanel();
        String[] columnNames = {"Player", "Wins", "Losses", "Draws"};

        if(list.size() > 0){
            rowData = new Object[list.size()][columnNames.length];
            rowData = queryData(list, columnNames);
        }
        else
            rowData = new Object[17][4];

        JTable table = new JTable(rowData, columnNames);

        table.setForeground(Color.BLACK);                  
        table.setFont(new Font(null, Font.PLAIN, 16));     
        table.setSelectionForeground(Color.DARK_GRAY);      
        table.setSelectionBackground(Color.LIGHT_GRAY);    
        table.setGridColor(Color.GRAY);                     

        table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  
        table.getTableHeader().setForeground(Color.BLACK);                
        table.getTableHeader().setResizingAllowed(false);              
        table.getTableHeader().setReorderingAllowed(false);             

        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.setPreferredScrollableViewportSize(new Dimension(500, 510));
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        
        this.add(panel);
        this.setSize(900,600);
        this.setResizable(false);
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setVisible(true);
    }
    
    public Object[][] queryData(ArrayList<player> list, String[] columnNames){
        Object[][] data=new Object[list.size()][columnNames.length];

        for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).getPlayerName();
                data[i][1]=list.get(i).getWins();
                data[i][2]=list.get(i).getLosses();
                data[i][3]=list.get(i).getDraws();
        }
        return data;
    }
    
}
