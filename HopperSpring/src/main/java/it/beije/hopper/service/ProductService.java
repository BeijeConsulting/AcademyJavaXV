package it.beije.hopper.service;


import it.beije.hopper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private UserRepository userRepository;

        public ProductService(){
            System.out.println("Product Service created... ");
        }



}
