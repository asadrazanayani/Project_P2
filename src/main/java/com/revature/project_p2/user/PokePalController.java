package com.revature.project_p2.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping ("api/v1/user")
public class PokePalController {

    @Autowired
    PokePalService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PokePal> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public PokePal userRegister(@RequestBody PokePal user) {
        return userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public PokePal userLogin(@RequestBody PokePal pokepal) {
        return userService.login(pokepal);
    }

    @PostMapping (
            path = "{user_id}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImg(@PathVariable("user_id") Long user_id,
                                     @RequestParam("file") MultipartFile file) {
        userService.uploadUserProfileImg(user_id, file);

    }

    @RequestMapping(value = "{user_id}/image/download", method = RequestMethod.GET)
    public byte[] downloadUserProfileImage(@PathVariable("user_id") Long user_id) {
        return userService.downloadProfileImage(user_id);
    }





}
