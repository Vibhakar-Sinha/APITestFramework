package api.endpoints;
/*
Swagger URI - https://petstore.swagger.io/

Create user (Post) : https://petstore.swagger.io/v2/user
Get User (Get) : https://petstore.swagger.io/v2/user/{username}
Update User (Put) : https://petstore.swagger.io/v2/user/{username}
Delete User (Delete) : https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {

    public static String base_url="https://petstore.swagger.io/v2";

    //User Module
    public static String create_user_post_url=base_url+"/user";
    public static String get_user_get_url=base_url+"/user/{username}";
    public static String update_user_put_url =base_url+"/user/{username}";
    public static String delete_url_delete_url=base_url+"/user/{username}";

    //Pet module
    //Add Pet module URL's

    //Store module
    //Add Store module URL's
}
