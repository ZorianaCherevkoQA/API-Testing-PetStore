package api;

import api.steps.UserSteps;
import api.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.utils.AssertsUtil.*;
import static io.restassured.RestAssured.*;
import static properties.TestData.GET_USER_JSON;


public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test(groups = {"deleteUser"})
    public void checkCreateUser() {
        assertStatusCode(userSteps.createUser(userObject), 200);
    }

    @Test(groups = {"createUser", "deleteUser"})
    public void checkGetUser() {
        assertCodeAndJson(userSteps.getUser(userObject), GET_USER_JSON, 200);
    }
}
