package api.steps;

import api.builders.CreateUser;
import api.objects.User;
import api.utils.BuilderUtil;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static api.endpoints.Endpoints.*;
import static api.utils.ApiServices.*;
import static properties.TestData.USERNAME_PATH;

public class UserSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();


    @Step("Create user")
    public Response createUser(User user) {
        CreateUser createUser = builderUtil.buildCreateUser(user.getId(), user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getUserStatus());
        return postRequest(CREATE_USER, null, createUser, null, null);
    }

    @Step("Get user info")
    public Response getUser(User user) {
        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(USERNAME_PATH, user.getUsername());

        return getRequest(USER_NAME, null, null, null, pathParams);
    }

    @Step("Delete user")
    public Response deleteUser(User user) {
        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(USERNAME_PATH, user.getUsername());

        return deleteRequest(USER_NAME, null, null, null, pathParams);
    }

}
