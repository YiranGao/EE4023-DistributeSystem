/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class player {
    private String playerName;
    private int wins;
    private int losses;
    private int draws;
    public player(){
        playerName = "";
        wins = 0;
        losses = 0;
        draws = 0;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public String getPlayerName(){
        return playerName;
    }
     public void setWins(int wins){
        this.wins = wins;
    }
    public int getWins(){
        return wins;
    }
     public void setLosses(int losses){
        this.losses = losses;
    }
    public int getLosses(){
        return losses;
    }
     public void setDraws(int draws){
        this.draws = draws;
    }
    public int getDraws(){
        return draws;
    }
}
