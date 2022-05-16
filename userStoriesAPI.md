## User Stores and API
|**Story**|**API**|
|---|---|
|A visitor can view cards of pokedex cards. However, only a user is able to add them to their collection |/api/v1/pokedex-cards|
|New user should be able to register|/api/v1/user/register|
|New user should be able to login|/api/v1/user/login|
|User should be able to update their profile picture |/api/v1/user/{user_id}/update|
|User should be able to update their profile password |/api/v1/user/{user_id}/update|
|Create  a new pokedex collection|api/v1/user/{user_id}/pokedex-collection/create|
|Update the pokedex collection|/api/v1/user/{user_id}/pokedex-collection/update|
|Create  a new pokedex wishlist|/api/v1/user/{user_id}/pokedex-wishlist/create|
|Update the pokedwishlist|/api/v1/user/{user_id}/pokedex-wishlist/update|
|View all of pokedex collection on our website|/api/v1/user/{user_id}/pokedex-collection/view_all|
|View all of pokedex collection on our website. Sorted by upvotes |/api/v1/user/{user_id}/pokedex-collection/view_all/sorted/?upvotes={DESC/ASC}|
|View all of pokedex collection on our website. Sorted by comments|/api/v1/user/{user_id}/pokedex-collection/view_all/sorted/?comments-total={DESC/ASC}|
|View all of pokedex collection on our website. Sorted by created_at |/api/v1/user/{user_id}/pokedex-collection/view_all/sorted/?comments-timestamp={DESC/ASC}|
|View all of pokedex collection on our website. Sorted by number of pokedex |/api/v1/user/{user_id}/pokedex-collection/view_all/sorted/?number-of-pokedex={DESC/ASC}|
|View all of pokedex wishlist on our website|/api/v1/user/{user_id}/pokedex-wishlist/view_all|
|View all of pokedex wishlist on our website. Sorted by upvotes |/api/v1/user/{user_id}/pokedex- wishlist /view_all/sorted/?upvotes={DESC/ASC}|
|View all of pokedex wishlist on our website. Sorted by comments |/api/v1/user/{user_id}/pokedex- wishlist /view_all/sorted/?comments-total={DESC/ASC}|
|View all of pokedex wishlist on our website. Sorted by created_at |/api/v1/user/{user_id}/pokedex- wishlist /view_all/sorted/?comments-timestamp={DESC/ASC}|
|View all of pokedex wishlist on our website. Sorted by number of pokedex | /api/v1/user/{user_id}/pokedex-wishlist/view_all/sorted/?number-of-pokedex={DESC/ASC}|

https://pokemondb.net/pokedex/stats/gen1

