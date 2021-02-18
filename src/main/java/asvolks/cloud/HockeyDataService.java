package asvolks.cloud;

import asvolks.cloud.Congifuration.ApiProperties;
import asvolks.cloud.Congifuration.Constants;
import asvolks.cloud.models.Hockey.Team;
import asvolks.cloud.models.Hockey.TeamsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class HockeyDataService {


    @Autowired
    RestTemplate template;

    @Autowired
    ApiProperties apiProps;

    private static final Logger logger = LoggerFactory.getLogger(ServiceBusApplication.class);

    public List<Team> getTeams(String leagueId, String season){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set(apiProps.getKey(), apiProps.getKeyValue());
        //headers.set("league","57");
        //headers.set("season","2019");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiProps.getTeamsUrl())
                .queryParam(Constants.LEAGUE,leagueId)
                .queryParam(Constants.SEASON,season);



        HttpEntity<String> entity = new HttpEntity<String>(headers);

        TeamsResponse result = template.exchange(builder.toUriString(), HttpMethod.GET, entity, TeamsResponse.class).getBody();




        if(result == null){
            logger.info("fail");
        }

        return result.getResponse();



    }


}
