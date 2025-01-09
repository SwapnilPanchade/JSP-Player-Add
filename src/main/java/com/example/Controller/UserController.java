package com.example.Controller;

import com.example.Dao.PlayerDao;
import com.example.Entity.Player;
import com.example.Entity.User;
import com.example.Service.PlayerService;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerDao playerDao;

    @GetMapping("/")
    public String tryLogin(){
        System.err.println("This is user controller");
        return "login";
    }

    @GetMapping("login")
    public String login(){
        System.err.println("This is login method call");
        return "login";
    }

    @PostMapping("login")
    public String userLogin(@ModelAttribute User user, Model model){
        if( userService.userLogin(user)) {
            getAllPlayers(model);
            return "player";
        }
        else {
            model.addAttribute("login", "Invalid Credientials");
            return "redirect:/login";
        }
    }


    @GetMapping("players")
    public String getAllPlayers(Model model){
        List<Player> players = playerDao.allPlayers();

        model.addAttribute("players", players);

        return "player";
    }

    @GetMapping("register")
    public String showRegister(){
        return "register";
    }


    @PostMapping("register")
    public String registerUser(@RequestParam("username") String username , @RequestParam String password , Model model){
        if(userService.addUser(username, password)){
            System.err.println("User added Successfully");
            System.err.println("username : "+username);
            System.err.println("password : "+password);
        }
        return "redirect:/";
    }



    @GetMapping("addplayer")
    public String addPlayer(){
        return "addplayer";
    }

    @PostMapping("addplayer")
    public String addPlayer(@ModelAttribute Player player, Model model){
        playerService.addPlayer(player);
        getAllPlayers(model);
        return "player";
    }

}
