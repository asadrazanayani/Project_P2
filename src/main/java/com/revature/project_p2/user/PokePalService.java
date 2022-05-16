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

    public boolean login(PokePal user) {
        boolean is_accurate = false;
        List<PokePal> users = userRepository.findUserForLogin(user.getUser_email(), user.getUser_password());
        is_accurate =
                (users.get(0).getUser_email() == user.getUser_email()
                        && users.get(0).getUser_password() == user.getUser_password());
        return is_accurate;
    }
}