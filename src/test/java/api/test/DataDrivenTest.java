package api.test;

import api.endpoints.User;
import api.endpoints.UserEndPoints;
import api.utilities.Dataproviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {


    @Test(priority = 1,dataProvider = "Data",dataProviderClass = Dataproviders.class)
    public void testPostUser(String userID,String userName,String fName,String lName,String userEmail,String pwd,String ph){

        User userPayload=new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUserName(userName);
        userPayload.setFirstName(fName);
        userPayload.setLastName(lName);
        userPayload.setEmail(userEmail);
        userPayload.setPassword(pwd);
        userPayload.setPhoneNo(ph);

        Response response=UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = Dataproviders.class)
    public void testDeleteUserByName(String userName){

        Response response=UserEndPoints.deleteUser(userName);
        //Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getStatusCode(),404);
    }

}
