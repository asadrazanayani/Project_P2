package com.revature.project_p2.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/user")
public class PokePalController {

    @Autowired
    PokePalService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public PokePal register_new_user(@RequestBody PokePal newUser){
        List<PokePal> users = userService.userRepository.findAll();

        System.out.println("New user: " +newUser.toString());

        for (PokePal user: users){
            System.out.println("Registered user: " +newUser);
            if(user.equals(newUser)) {
                System.out.println("Username already exists!");
                return null;
            }
        }
        userService.userRepository.save(newUser);
        return newUser;
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public PokePal login_user(@RequestBody PokePal user) {
        List<PokePal> users = userService.userRepository.findAll();

        for(PokePal login: users){
            if(login.equals(user)) {
                user.setIs_logged_in(true);
                userService.userRepository.save(user);
                return user;
            }
        }
        return null;
    }

    @PutMapping("/{user_id}/update")
    public PokePal update_user_picture(@RequestBody PokePal user, @PathVariable("user_id") long user_id){
        return userService.update_user_picture(user, user_id);
    }

    @PutMapping("/{user_id}/update")
    public PokePal update_user_password(@RequestBody PokePal user, @PathVariable("user_id") long user_id){
        return userService.update_user_password(user, user_id);
    }

}
