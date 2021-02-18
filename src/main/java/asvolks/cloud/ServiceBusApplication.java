package asvolks.cloud;

import asvolks.cloud.Congifuration.Properties;
import asvolks.cloud.models.Hockey.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceBusApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBusApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(ServiceBusApplication.class);

	@Autowired
	Properties props;

	@Autowired
	MessageSender sender;

	@Autowired
	HockeyDataService hockeyService;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {



		for(Team team : hockeyService.getTeams("57","2019")){
			sender.sendTeamMessage(team);
		}
		//sender.sendBasicMessage("test");


		//logger.info(props.getQueueName());
	}

}
