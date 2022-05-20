package com.revature.project_p2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokePalService {

    @Autowired
    PokePalRepository userRepository;

    public void register(PokePal user) {
        userRepository.save(user);
    }

    public boolean login(String email, String password) {
        boolean is_accurate = false;
        List<PokePal> users = userRepository.findUserForLogin(email, password);
        is_accurate =
                (users.get(0).getUser_email() == email
                        && password == password);
        return is_accurate;
    }

    public PokePal getPokePalByID(Long user_id) {
        return userRepository.findById(user_id).get();
    }

    public List<PokePal> getAllUsers() {
        return userRepository.findAll();
    }
}
