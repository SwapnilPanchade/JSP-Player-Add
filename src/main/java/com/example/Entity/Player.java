package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String playerName;
    private String playerAge;
    private String teamName;


    public Player() {
    }

    public Player(int pid, String playerName, String playerAge, String teamName) {
        this.pid = pid;
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.teamName = teamName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(String playerAge) {
        this.playerAge = playerAge;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", playerName='" + playerName + '\'' +
                ", playerAge='" + playerAge + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
