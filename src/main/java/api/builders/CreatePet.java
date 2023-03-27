package api.builders;

import api.enums.Statuses;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CreatePet {

    private int id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private Statuses status;
}
