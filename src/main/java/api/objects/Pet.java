package api.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pet {

    public String name;
    public List<String> photoUrls;

    public Pet(String name) {
        this.name = name;
    }
}
