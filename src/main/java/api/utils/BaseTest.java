package api.utils;

import api.steps.PetSteps;
import api.steps.UserSteps;
import io.restassured.response.Response;
import org.testng.annotations.*;

import static api.enums.Categories.dog;
import static api.enums.Statuses.available;
import static api.utils.ApiUtils.getIntResponseValue;
import static properties.TestData.*;

public class BaseTest extends Base {

    public static Response user;

    public static Response pet;
    public static int petId;

    private final UserSteps userSteps = new UserSteps();
    private final PetSteps petSteps = new PetSteps();

    @BeforeMethod(alwaysRun = true, onlyForGroups = "createUser")
    public void createUser() {
        user = userSteps.createUser(userObject);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = "createPet")
    public void createPet() {
        pet = petSteps.createPet(petObject, dog, available);
        petId = getIntResponseValue(pet, ID_KEY);
    }

    @AfterMethod(alwaysRun = true, onlyForGroups = "deletePet")
    public void deletePet() {
        petSteps.deletePet(petId);
    }

    @AfterMethod(alwaysRun = true, onlyForGroups = "deleteUser")
    public void deleteUser() {
        userSteps.deleteUser(userObject);
    }
}
