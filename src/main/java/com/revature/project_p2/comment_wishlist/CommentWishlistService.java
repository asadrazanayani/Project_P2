//package com.revature.project_p2.comment_wishlist;
//
//import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
//import com.revature.project_p2.pokedex_wishlist.PokedexWishlistService;
//import com.revature.project_p2.user.PokePal;
//import com.revature.project_p2.user.PokePalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CommentWishlistService {
//
//    @Autowired
//    CommentWishlistRepository commentWishlistRepository;
//    @Autowired
//    PokedexWishlistService pokedexWishlistService;
//    @Autowired
//    PokePalService pokePalService;
//
//    public CommentWishlist addCommentToWishlist(CommentWishlist commentWishlist, Long commenter_id_long, Long wishlist_id_long) {
//        PokePal pokePal = pokePalService.getPokePalByID(commenter_id_long);
//        PokedexWishlist pokedexWishlist = pokedexWishlistService.getpokedexWishlistByID(wishlist_id_long);
//        commentWishlist.setUser(pokePal);
//        commentWishlist.setPokedexWishlist(pokedexWishlist);
//        return commentWishlistRepository.save(commentWishlist);
//    }
//}

package com.revature.project_p2.comment_wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentWishlistService {

    @Autowired
    CommentWishlistRepository commentWishlistRepository;

    public CommentWishlist add_comment(CommentWishlist commentWishlist) {
        return commentWishlistRepository.save(commentWishlist);
    }

    public List<CommentWishlist> getCommentsForWishlist(Long user_id_wishlist) {
        return commentWishlistRepository.getCommentsForWishlist(user_id_wishlist);
    }
}


