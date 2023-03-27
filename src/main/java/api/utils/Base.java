package api.utils;

import api.objects.Pet;
import api.objects.User;
import org.aeonbits.owner.ConfigFactory;
import properties.TestInitValues;

import static properties.TestData.PET_NAME;

public class Base {

    public static final TestInitValues testProp = ConfigFactory.create(TestInitValues.class);

    public static final User userObject = new User(testProp.id(), testProp.username(), testProp.firstName(), testProp.lastName(), testProp.email(), testProp.password(), testProp.phone(), testProp.userStatus());

    public static final Pet petObject = new Pet(PET_NAME);
}
