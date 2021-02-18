package asvolks.cloud;


import asvolks.cloud.models.Hockey.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

@EnableBinding(Source.class)
public class MessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);


    @Autowired
    private Source source;


    public String sendBasicMessage(String message){
        logger.info("From send basic message {}",message );
        Map headers = new HashMap();
        headers.put("key1","value1");

        headers.put("key2","value2");
        this.source.output().send(new GenericMessage<>(message,headers));
        return message;
    }

    public void sendTeamMessage(Team team){
        logger.info("we are attempting to send team {}", team.getName());
        Map headers = new HashMap();
        headers.put("type","Team");

        this.source.output().send(new GenericMessage<>(team,headers));
    }



}

