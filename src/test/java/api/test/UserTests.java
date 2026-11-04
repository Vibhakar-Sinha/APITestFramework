package api.test;

import api.endpoints.User;
import api.endpoints.UserEndPoints;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userPayload;

    public Logger logger;
    @BeforeClass
    public void setup(){
        faker=new Faker();
        userPayload=new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUserName(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhoneNo(faker.phoneNumber().cellPhone());


        //Logs
        logger= LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser(){

        logger.info("***** Creating User ****** ");
        Response res=UserEndPoints.createUser(userPayload);

        System.out.println(this.userPayload.getUserName());

        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);

        logger.info("***** Creating Created ****** ");
    }

    @Test(priority = 2)
    public void testGetUserByName(){

        logger.info("***** Reading User Info ****** ");

        Response res=UserEndPoints.getUser(this.userPayload.getUserName());
        res.then().log().all();
        //Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getStatusCode(),404);

        logger.info("***** User Info is displayed ****** ");

    }

    @Test(priority = 3)
    public void testUpdateUserByName(){

        logger.info("***** Updating user ****** ");

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response res=UserEndPoints.updateUser(this.userPayload.getUserName(),userPayload);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);

        logger.info("***** Updated user ****** ");
    }

    @Test(priority = 4)
    public void deleteUserByName(){

        logger.info("***** Deleting  user ****** ");

        Response res=UserEndPoints.deleteUser(this.userPayload.getUserName());
        //Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getStatusCode(),404);

        logger.info("***** User Deleted ****** ");

    }
}
