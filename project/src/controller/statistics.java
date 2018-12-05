/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.player;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
import view.ScoreSystemUI;
import view.StatisticsUI;

/**
 *
 * @author dell
 */
public class statistics {
    
    private static TTTWebService proxy; 
    private TTTWebService_Service service;
    private static StatisticsUI StatisticsPage;
    private static ScoreSystemUI ScoreSystemPage;
    private static ArrayList<player> list = null;
    private static String playerName;
    
    public statistics(String playerName){
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        this.playerName = playerName;
        list = new ArrayList<player>();
    }
    public void setData(){
        String result = proxy.leagueTable();
        if(result.equals("ERROR-NOGAMES")){
            System.out.println(result);
        }
        else if(result.equals("ERROR-DB")){
            System.out.println(result);
        }
        else{
            result = result.replace("{", "");
            result = result.replace("}", "");
            String [] array = result.split("\n");
            for(int i = 0; i < array.length; i++){
                String [] str = array[i].split(",");
                boolean flag = false;
                for(int k = 0; k < list.size(); k++){
                    if(str[1].equals(list.get(k).getPlayerName())){
                        addCountFor1(k,str[3]);
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    list.add(new player());
                    list.get(list.size() - 1).setPlayerName(str[1]);
                    addCountFor1(list.size() - 1,str[3]);
                }

                for(int k = 0; k < list.size(); k++){
                    if(str[2].equals(list.get(k).getPlayerName())){
                        addCountFor2(k,str[3]);
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    list.add(new player());
                    list.get(list.size() - 1).setPlayerName(str[2]);
                    addCountFor2(list.size() - 1,str[3]);
                }
            }
        }
    }
    
    public void showStatistic(){
        StatisticsPage = new StatisticsUI(list);
    }
     
    public void addCountFor1(int i, String str){
        if(str.equals("1")){
            int sum = list.get(i).getWins();
            list.get(i).setWins(sum + 1);
        }
        else if(str.equals("2")){
            int sum = list.get(i).getLosses();
            list.get(i).setLosses(sum + 1);
        }
        else if(str.equals("3")){
            int sum = list.get(i).getDraws();
            list.get(i).setDraws(sum + 1);
        }         
    }
    
    public void addCountFor2(int i, String str){
        if(str.equals("1")){
           int sum = list.get(i).getLosses();
            list.get(i).setLosses(sum + 1);
        }
        else if(str.equals("2")){
            int sum = list.get(i).getWins();
            list.get(i).setWins(sum + 1);
        }
        else if(str.equals("3")){
            int sum = list.get(i).getDraws();
            list.get(i).setDraws(sum + 1);
        }         
    }
    
    public void getScoreSystem(String playerName){
        player thisPlayer = new player();
        thisPlayer.setPlayerName(playerName);
        for(int k = 0; k < list.size(); k++){
            if(playerName.equals(list.get(k).getPlayerName())){
                thisPlayer.setWins(list.get(k).getWins());
                thisPlayer.setLosses(list.get(k).getLosses());
                thisPlayer.setDraws(list.get(k).getDraws());
            }
        }
        ScoreSystemPage = new ScoreSystemUI(thisPlayer);
    }
}
