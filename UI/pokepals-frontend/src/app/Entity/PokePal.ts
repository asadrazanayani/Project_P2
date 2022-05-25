import { PokedexCollection } from "./PokedexCollection";
import { PokedexWishlist } from "./PokedexWishlist";
import { CommentCollection } from "./CommentCollection";
import { CommentWishlist } from "./CommentWishlist";

export interface PokePal {
    user_id: number;
    user_name: string;
    user_email : string;
    user_password : string;
    user_img_url : string;
    is_logged_in : boolean;
    pokedexCollection: any[];
    pokedexWishlist: any[];
    commentCollections : any[];
    commentWishlist :  any[];
}