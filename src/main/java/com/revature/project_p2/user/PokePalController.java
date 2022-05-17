package com.revature.project_p2.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/user")
public class PokePalController {

    @Autowired
    PokePalService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public PokePal userRegister(@RequestBody PokePal user) {
        userService.register(user);
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public boolean userLogin(@RequestBody String email, @RequestBody String password) {
        return userService.login(email, password);
    }

}
