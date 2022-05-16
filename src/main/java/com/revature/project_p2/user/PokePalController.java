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
    public void userRegister(@RequestBody PokePal user) {
        userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public void userLogin(@RequestBody PokePal user) {
        userService.login(user);
    }

}
