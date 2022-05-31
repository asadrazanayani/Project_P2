package com.revature.project_p2;

import com.revature.project_p2.comment_collection.CommentCollection;
import com.revature.project_p2.comment_collection.CommentCollectionService;
import com.revature.project_p2.comment_wishlist.CommentWishlist;
import com.revature.project_p2.comment_wishlist.CommentWishlistService;
import com.revature.project_p2.pokedex_collection.PokedexCollection;
import com.revature.project_p2.pokedex_collection.PokedexCollectionService;
import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
import com.revature.project_p2.pokedex_wishlist.PokedexWishlistService;
import com.revature.project_p2.user.PokePal;
import com.revature.project_p2.user.PokePalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

@SpringBootTest // used to write the integration test.
//@AutoConfigureMockMvc
class ProjectP2ApplicationTests {

	@Autowired
	PokePalService pokePalService;

	@Autowired
	PokedexCollectionService pokedexCollectionService;

	@Autowired
	PokedexWishlistService pokedexWishlistService;

	@Autowired
	CommentCollectionService commentCollectionService;

	@Autowired
	CommentWishlistService commentWishlistService;

	// https://www.baeldung.com/junit-5-test-order


	@Test
	void contextLoads() {
	}

	@Test
	void CollectiveTests() {

		// Users tests
		// 1. Register user
		PokePal pokePal = new PokePal("asad", "asad@domain.com", "123", "imageUrl");
		PokePal returnPokePal = pokePalService.register(pokePal);
		Assertions.assertTrue(returnPokePal.getUser_id() > 0);
		// 2. Login user
		returnPokePal = pokePalService.login(returnPokePal);
		Assertions.assertTrue(returnPokePal.getIs_logged_in());
		// 3. Get user
		returnPokePal = pokePalService.getUserInfo(returnPokePal.getUser_id());
		Assertions.assertTrue(returnPokePal.getUser_id() > 0);
		// 4. Update user
		returnPokePal.setUser_email("asadr@domain.com");
		returnPokePal = pokePalService.updateUserInfo(returnPokePal, returnPokePal.getUser_id());
		Assertions.assertTrue(returnPokePal.getUser_email().equals("asadr@domain.com"));
		// 5. Get All User
		List<PokePal> pokePals = pokePalService.getAllUsers();
		Assertions.assertTrue(pokePals.size() > 0);

		// Collection test
		// 1. Add to collection
		PokedexCollection pokedexCollection = new PokedexCollection("bulbasaur", "grass", 64L,
				"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png","razor-wind",
				returnPokePal);
		PokedexCollection returnCollection = pokedexCollectionService.addPokedexCollection(pokedexCollection);
		Assertions.assertTrue(returnCollection.getCollection_id() > 1);
		// 2. Get From Collection
		List<PokedexCollection> collections = pokedexCollectionService.getPokedexCollectionByID(returnPokePal.getUser_id());
		Assertions.assertTrue(collections.size() > 0);

		// Wishlist test
		// 1. Add to Wishlist
		PokedexWishlist pokedexWishlist = new PokedexWishlist("bulbasaur", "grass", 64L,
				"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png","razor-wind",
				returnPokePal);
		pokedexWishlist = pokedexWishlistService.addPokedexWishlist(pokedexWishlist);
		Assertions.assertTrue(pokedexWishlist.getWishlist_id() > 1);
		// 2. Get From Wishlist
		List<PokedexWishlist> wishlists = pokedexWishlistService.getpokedexWishlistByID(returnPokePal.getUser_id());
		Assertions.assertTrue(wishlists.size() > 0);

		// Comment test
		// 1. Add new comment;
		PokePal commenter = new PokePal("commenter", "commenter@domain.com", "123", "imageUrl");
		commenter = pokePalService.register(commenter);
		// PokePal commenter, PokePal pokePal, String content
		CommentCollection commentCollection = new CommentCollection(commenter, returnPokePal, "Hello");
		commentCollection = commentCollectionService.add_comment(commentCollection);
		Assertions.assertTrue(commentCollection.getComment_id() > 0);
		// 2. Get a comment
		List<CommentCollection> commentCollections = commentCollectionService.getCommentsForCollection(returnPokePal.getUser_id());
		Assertions.assertTrue(commentCollections.size() > 0);

		Assertions.assertTrue((pokePalService.getUserForCommentCollection(commentCollection.getComment_id())).getUser_id() > 0);

		// Wishlist test
		// 1. Add new comment_wishlist;
		// PokePal commenter, PokePal pokePal, String content
		CommentWishlist commentWishlist = new CommentWishlist(commenter, returnPokePal, "Hello");
		commentWishlist = commentWishlistService.add_comment(commentWishlist);
		Assertions.assertTrue(commentWishlist.getComment_id_wishlist() > 0);
		// 2. Get a comment_wishlist
		List<CommentWishlist> commentWishlists = commentWishlistService.getCommentsForWishlist(returnPokePal.getUser_id());
		Assertions.assertTrue(commentWishlists.size() > 0);

		Assertions.assertTrue((pokePalService.getUserForCommentWishlist(commentWishlist.getComment_id_wishlist ())).getUser_id() > 0);


		//https://www.tabnine.com/code/java/classes/org.springframework.mock.web.MockMultipartFile
		MockMultipartFile multipartFile = new MockMultipartFile("hello", "hello.txt", MediaType.TEXT_PLAIN_VALUE,
				"Hello, World!".getBytes());
		pokePalService.uploadUserProfileImg(returnPokePal.getUser_id(), multipartFile);
		// the user img url should change to the file name
		returnPokePal = pokePalService.getUserInfo(returnPokePal.getUser_id());
		Assertions.assertTrue(returnPokePal.getUser_img_url().equals("hello.txt"));
		// the bytes when converted to string should return the text inside the file
		String string = new String(pokePalService.downloadProfileImage(returnPokePal.getUser_id()));
		Assertions.assertTrue(string.equals("Hello, World!"));

		returnPokePal = pokePalService.logout(returnPokePal);
		Assertions.assertTrue(!returnPokePal.getIs_logged_in());





	}

}



