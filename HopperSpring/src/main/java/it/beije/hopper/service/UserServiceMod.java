package it.beije.hopper.service;

import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepositoryMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceMod {
    @Autowired
    private UserRepositoryMod userRepositoryMod;
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
    public User findByEmailAndPassword(String email, String password) {
        return userRepositoryMod.findByEmailAndPassword(email, password);
    }
    public ArrayList<User> findByLastNameAndFirstName(String lastName, String firstName){
       return userRepositoryMod.findByLastNameAndFirstName(lastName, firstName);
    }

    public List<User> findAll(){
        return userRepositoryMod.findAll();
    }

//    public void signUpUser(String email, String password, String lastName, String firstName){
//        userRepositoryMod.signUpUser(email, password, lastName, firstName);
//    }
}
