package api.steps;

import api.builders.CreatePet;
import api.enums.Categories;
import api.enums.Statuses;
import api.objects.Pet;
import api.utils.BuilderUtil;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static api.endpoints.Endpoints.*;
import static api.utils.ApiServices.*;
import static api.utils.Base.testProp;
import static properties.TestData.*;

public class PetSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();

    @Step("Create pet")
    public Response createPet(Pet pet, Categories category, Statuses status) {
        CreatePet createPet = builderUtil.buildCreatePet(pet.getName(), category, status);
        return postRequest(PET, null, createPet, null, null);
    }

    @Step("Delete pet")
    public Response deletePet(int petId) {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put(API_KEY, testProp.api_key());

        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(PET_ID_PATH, petId);

        return deleteRequest(PET_ID, headers, null, null, pathParams);
    }

    @Step("Get pet info")
    public Response getPet(int petId) {
        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(PET_ID_PATH, petId);

        return getRequest(PET_ID, null, null, null, pathParams);
    }

    @Step("Update pet info")
    public Response updatePet(int petId, Statuses status) {
        CreatePet createPet = builderUtil.buildCreatePet(petId, status);
        return putRequest(PET, null, createPet, null, null);
    }
}
