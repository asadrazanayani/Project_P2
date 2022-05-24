//package com.revature.project_p2.comment_wishlist;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "api/v1/users/{commenter_id}/pokedex-wishlist/{wishlist_id}/comments")
//
//public class CommentWishlistController {
//
//    @Autowired
//    CommentWishlistService commentWishlistService;
//
//    @RequestMapping(path = "/add", method = RequestMethod.POST)
//    public CommentWishlist addCommentToWishlist(@RequestBody CommentWishlist commentWishlist,
//                                @PathVariable("commenter_id") String commenter_id,
//                                @PathVariable("wishlist_id") String wishlist_id) {
//        Long commenter_id_long = Long.parseLong(commenter_id);
//        Long wishlist_id_long = Long.parseLong(wishlist_id);
//        return commentWishlistService.addCommentToWishlist(commentWishlist, commenter_id_long, wishlist_id_long);
//
//    }
//}

package com.revature.project_p2.comment_wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments-wishlist")
public class CommentWishlistController {

    @Autowired
    CommentWishlistService commentWishlistService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommentWishlist add_comment_Wishlist(@RequestBody CommentWishlist commentwishlist) {
        return commentWishlistService.add_comment(commentwishlist);
    }

    @RequestMapping(value = "/{user_id_wishlist}", method = RequestMethod.GET)
    public List<CommentWishlist> getCommentsForWishlist(@PathVariable("user_id_wishlist") Long user_id_wishlist) {
        return commentWishlistService.getCommentsForWishlist(user_id_wishlist);
    }


}
