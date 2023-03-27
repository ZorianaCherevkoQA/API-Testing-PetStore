package api;
import api.steps.PetSteps;
import api.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import static api.enums.Categories.dog;
import static api.enums.Statuses.*;
import static api.utils.ApiUtils.*;
import static api.utils.AssertsUtil.*;
import static org.testng.Assert.assertEquals;
import static properties.TestData.*;

public class PetTests extends BaseTest {

    private final PetSteps petSteps = new PetSteps();

    @Test(groups = {"deletePet"})
    @Description("POST /pet")
    public void checkCreatePet() {
        pet = petSteps.createPet(petObject, dog, available);
        petId = getIntResponseValue(pet, ID_KEY);
        assertCodeAndJson(pet, CREATE_PET_JSON, 200);
    }

    @Test(groups = {"createPet"})
    @Description("DELETE /pet/{petId}")
    public void checkDeletePet() {
        assertStatusCode(petSteps.deletePet(petId), 200);
    }

    @Test(groups = {"createPet", "deletePet"})
    @Description("GET /pet/{petId}")
    public void checkGetPet() {
        assertCodeAndJson(petSteps.getPet(petId), GET_PET_JSON, 200);
    }

    @Test(groups = {"createPet", "deletePet"})
    @Description("PUT /pet")
    public void checkUpdatePet() {
        assertStatusCode(petSteps.updatePet(petId, pending), 200);
        assertEquals(getResponseValue(petSteps.getPet(petId), STATUS_KEY), pending.toString());
    }
}
