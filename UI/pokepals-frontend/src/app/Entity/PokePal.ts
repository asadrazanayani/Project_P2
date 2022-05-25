import { PokedexCollection } from "./PokedexCollection";

export interface PokePal {
    user_id: number;
    user_name: string;
    user_email : string;
    user_password : string;
    user_img_url : string;
    is_logged_in : boolean;
    // pokedex_collection_size : number;
    // pokedex_collection : PokedexCollection[];

}