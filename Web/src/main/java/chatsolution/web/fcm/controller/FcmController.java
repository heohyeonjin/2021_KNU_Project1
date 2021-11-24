package chatsolution.web.fcm.controller;


import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.clientAPI.message.service.ClientMessageService;
import chatsolution.web.fcm.service.FirebaseCloudMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FcmController {

    private final ClientMessageService messageClientService;
//
//    // web에서 푸시알림
//    @PostMapping("/counselor/fcm/send")
//    public void sendNotification(String token, String title, String content) throws IOException {
//        // 받을 것 : 기업 이름, 내용, token
//        fcmService.sendMessageTo(token, title, content);
//    }

    @PostMapping("/getToken") @Transactional
    public String tokenUpdate(String token, HttpServletRequest request){
        Client client = messageClientService.getClient(request.getSession()); //고객 정보
        client.setFcmToken(token);
        return"true";
    }

}
