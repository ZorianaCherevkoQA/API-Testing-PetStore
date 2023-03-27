package api.utils;

import api.builders.Category;
import api.builders.CreatePet;
import api.builders.CreateUser;
import api.enums.Categories;
import api.enums.Statuses;

import java.time.Instant;
import java.util.List;

public class BuilderUtil {

    public CreateUser buildCreateUser(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        return CreateUser.builder()
                .id(id)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();
    }

    public CreatePet buildCreatePet(String name, Categories category, Statuses status) {
        return CreatePet.builder()
                .id(Instant.now().getNano())
                .name(name)
                .category(Category.builder()
                        .id(category.getId())
                        .name(category.getName()).build())
                .status(status)
                .build();
    }

    public CreatePet buildCreatePet(int petId, Statuses status) {
        return CreatePet.builder()
                .id(petId)
                .status(status)
                .build();
    }
}
