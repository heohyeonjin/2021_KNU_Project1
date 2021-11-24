package chatsolution.web.fcm.controller;


import chatsolution.web.fcm.service.FirebaseCloudMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FcmController {

    private final FirebaseCloudMessageService fcmService;

    // web에서 푸시알림
    @PostMapping("/counselor/fcm/send")
    public void sendNotification(String token, String title, String content) throws IOException {
        // 받을 것 : 기업 이름, 내용, token
        fcmService.sendMessageTo(token, title, content);
    }

}
