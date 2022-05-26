package com.revature.project_p2.user;

import com.revature.project_p2.utility.BucketName;
import com.revature.project_p2.utility.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class PokePalService {

    @Autowired
    PokePalRepository userRepository;
    @Autowired
    FileStore fileStore;

    public PokePal register(PokePal user) {
        return userRepository.save(user);
    }

    public PokePal login(PokePal pokepal) {
        List<PokePal> users = userRepository.findUserForLogin(pokepal.getUser_email(), pokepal.getUser_password());
        PokePal user = users.get(0);
        user.setIs_logged_in(true);
        return userRepository.save(user);
    }

    public List<PokePal> getAllUsers() {
        return userRepository.findAll();
    }

    public void uploadUserProfileImg(Long user_id, MultipartFile file) {
        // 1. Check of the image is not image
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload Empty File" + file.getSize());
        }
        // 2. If file is an image
        if (Arrays.asList(IMAGE_JPEG, IMAGE_PNG, IMAGE_GIF).contains(file.getContentType())) {
            throw new IllegalStateException("File Must Be of Type Img");
        }
        // 3. The user exists in our database
        PokePal pokePal = userRepository.findById(user_id).get();
        if (pokePal.getUser_id() != user_id) {
            throw new IllegalStateException("User Profile is Illegal/not found");
        }
        // 4. Grab some metadata from file any
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));
        // 5. Store the image in s3 and update database (userProfileImageLink) with s3 image link
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), pokePal.getUser_id());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.save(path, fileName, Optional.of(metaData), file.getInputStream());
            pokePal.setUser_img_url(fileName);
            userRepository.save(pokePal);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public byte[] downloadProfileImage(Long user_id) {
        PokePal pokePal = userRepository.findById(user_id).get();
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), pokePal.getUser_id());
        return fileStore.download(path, pokePal.getUser_img_url());

    }

    public PokePal logout(PokePal pokePal) {
        List<PokePal> users = userRepository.findUserForLogin(pokePal.getUser_email(), pokePal.getUser_password());
        PokePal user = users.get(0);
        user.setIs_logged_in(false);
        return userRepository.save(user);
    }

    public PokePal getUserInfo(Long user_id) {
        return userRepository.findById(user_id).get();
    }

    public PokePal getUserForCommentCollection(Long comment_id) {
        return userRepository.getUserForCommentCollection(comment_id);
    }

    public PokePal getUserForCommentWishlist(Long comment_id_wishlist) {
        return userRepository.getUserForCommentWishlist(comment_id_wishlist);
    }

    public PokePal updateUserInfo(PokePal pokePal, Long user_id) {
        PokePal updatedPokepal = userRepository.findById(user_id).get();
        updatedPokepal.setUser_name(pokePal.getUser_name());
        updatedPokepal.setUser_password(pokePal.getUser_password());
        updatedPokepal.setUser_email(pokePal.getUser_email());
        return userRepository.save(updatedPokepal);
    }

}
