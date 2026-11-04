package api.endpoints;
/*
Method implementation using CRUD
CRUD - Create, Retrieve, Update, delete
 */

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {


    static ResourceBundle getURL(){
        ResourceBundle bundle=ResourceBundle.getBundle("routes");
        return bundle;
    }


    public static Response createUser(User payload){

        String post_url=getURL().getString("create_user_post_url");

        Response res=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(post_url);

        System.out.println(post_url);
        return res;

    }

    public static Response getUser(String userName){

        String get_url=getURL().getString("get_user_get_url");

        System.out.println("Get User method:"+userName);
        System.out.println("Get User url:"+get_url);

        Response res=given()
                .pathParam("username",userName)

                .when()
                .get(get_url);

        return res;

    }

    public static Response updateUser(String userName,User payload){

        String update_url=getURL().getString("update_user_put_url");

        System.out.println("Update user:"+userName);
        System.out.println("Update User url:"+update_url);

        Response res=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)

                .when()
                .put(update_url);

        return res;

    }


    public static Response deleteUser(String userName){

        String delete_url=getURL().getString("delete_url_delete_url");

        System.out.println("Delete user name;"+userName);
        System.out.println("Delete user url;"+delete_url);

        Response res=given()
                .pathParam("username",userName)

                .when()
                .delete(delete_url);

        return res;

    }


}
