package api.endpoints;
/*
Method implementation using CRUD
CRUD - Create, Retrieve, Update, delete
 */

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response createUser(User payload){

        Response res=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.create_user_post_url);

        System.out.println(Routes.create_user_post_url);
        return res;

    }

    public static Response getUser(String userName){

        System.out.println("Get User method:"+userName);
        System.out.println("Get User url:"+Routes.get_user_get_url);

        Response res=given()
                .pathParam("username",userName)

                .when()
                .get(Routes.get_user_get_url);

        return res;

    }

    public static Response updateUser(String userName,User payload){

        System.out.println("Update user:"+userName);
        System.out.println("Update User url:"+Routes.update_user_put_url);

        Response res=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)

                .when()
                .put(Routes.update_user_put_url);

        return res;

    }


    public static Response deleteUser(String userName){

        System.out.println("Delete user name;"+userName);
        System.out.println("Delete user url;"+Routes.delete_url_delete_url);

        Response res=given()
                .pathParam("username",userName)

                .when()
                .delete(Routes.delete_url_delete_url);

        return res;

    }


}
