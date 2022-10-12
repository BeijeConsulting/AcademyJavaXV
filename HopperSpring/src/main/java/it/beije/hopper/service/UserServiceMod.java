package it.beije.hopper.service;

import it.beije.hopper.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceMod {

    public ArrayList<User> listUsers() {
       ArrayList<User> users = new ArrayList<>();
       User user = new User();
       user.setFirstName("pietro");
        User user2 = new User();
        user2.setFirstName("nico");
       users.add(user2);
       users.add(user);
        return users;
    }
}
