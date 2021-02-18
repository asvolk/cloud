package asvolks.cloud.models.Hockey;

import lombok.Data;

import java.util.List;

@Data
public class TeamsResponse {


    private String get;


    private HockeyParameters parameters;

    private List<String> errors;

    private String results;
    private List<Team> response;



}
