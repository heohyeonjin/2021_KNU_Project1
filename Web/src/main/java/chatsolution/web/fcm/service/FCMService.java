package chatsolution.web.fcm.service;


import chatsolution.web.message.model.Message;
import com.google.firebase.messaging.FirebaseMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FCMService {
//    private  static final Logger logger = LoggerFactory.getLogger(FCMService.class);
//
//    public void send(String tokenId, String title, String content) throws InterruptedException, ExecutionException{
//        Message message = Message.Builder()
//                .setToken(tokenId)
//                .putData("title",title)
//                .putData("message",content)
//                .build();
//
//        String response = FirebaseMessaging.getInstance().sendAsync(message).get();
//        logger.info("Sent message:" + response);
//    }
}
