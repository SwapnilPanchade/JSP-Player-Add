package com.example.Dao;

import com.example.Entity.Player;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Player> allPlayers() {

        Session session = sessionFactory.openSession();

        try {
            List<Player> players = session.createCriteria(Player.class).list();
            return players;
        } finally {
            session.close();
        }
    }

    public void addPlayer(Player player) {
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Player.class);
            session.saveOrUpdate(player);
        } finally {
            session.close();
        }
    }

    public void deletePlayer(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Player player = session.get(Player.class, id);
            if (player != null) {
                session.delete(player);
            }
            session.createCriteria(Player.class).addOrder(Order.asc("pid"));
            session.getTransaction().commit();

        } finally {

            session.close();
        }

    }
}
