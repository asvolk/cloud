package asvolks.cloud.Congifuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rapid.api")
@Data
public class ApiProperties {

    private String key;
    private String keyValue;
    private String teamsUrl;
}
