package asvolks.cloud;

import com.microsoft.azure.spring.integration.core.AzureHeaders;
import com.microsoft.azure.spring.integration.core.api.Checkpointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

@EnableBinding(Sink.class)
public class MessageReciever {

    private static final Logger logger = LoggerFactory.getLogger(MessageReciever.class);
    @StreamListener(Sink.INPUT)
    public void handleMessage(Message<Object> message, @Header(AzureHeaders.CHECKPOINTER) Checkpointer checkpointer, String id) {




        checkpointer.success().handle((r, ex) -> {
            if (ex == null) {

                if(message.getHeaders().get("type").equals("Team")){
                    logger.info("we have a team");
                    logger.info(message.getPayload().toString());
                }else{
                    logger.info("not sure what we have");
                }

            }
            return null;
        });
    }
}
