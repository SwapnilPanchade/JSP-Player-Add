package com.example.Service;

import com.example.Dao.PlayerDao;
import com.example.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public void addPlayer(Player player) {
        playerDao.addPlayer(player);

        System.err.println("Player successfully added ");
    }

    public void deletePlayer(int id) {
        System.err.println("This is player service : delete operation ");
        playerDao.deletePlayer(id);
    }
}
