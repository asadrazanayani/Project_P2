package com.revature.project_p2.common;

import com.revature.project_p2.user.PokePal;
import com.revature.project_p2.user.PokePalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VerifyUserLogin {
    @Autowired
    PokePalRepository pokePalRepository;
    public boolean isLoggedIn(PokePal pokePal) {
         PokePal pokepal = pokePalRepository.findById(pokePal.getUser_id()).get();
         return pokepal.getIs_logged_in();
    }
}
