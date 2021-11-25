package chatsolution.web.fcm.controller;


import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.clientAPI.message.service.ClientMessageService;
import chatsolution.web.fcm.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FcmController {

    private final ClientMessageService messageClientService;
    @PostMapping("/getToken")
    public String tokenUpdate(@RequestBody TokenDto token, HttpServletRequest request){
        Client client = messageClientService.getClient(request.getSession()); //고객 정보
        log.info("토큰 받았다");
        log.info(token.getToken());
        messageClientService.saveToken(client,token.getToken());
        log.info("토큰 저장");
        return"true";
    }

}
