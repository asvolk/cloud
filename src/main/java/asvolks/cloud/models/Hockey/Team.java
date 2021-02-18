package asvolks.cloud.models.Hockey;

import lombok.Data;

import java.util.List;
@Data
public class Team {


    private Integer id;
    private String name;
    private String logo;
    private String national;
    private Integer founded;

    private List<String> colors;

    private Arena arena;

    private Country country;
}
