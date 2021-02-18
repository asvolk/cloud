package asvolks.cloud.Congifuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.servicebus")
@Data
public class Properties {

    private String connectionString;
    private String idleTimeout;
    private String primaryKey;
    private String queueName;


}
