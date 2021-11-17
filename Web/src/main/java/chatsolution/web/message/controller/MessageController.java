package chatsolution.web.message.controller;

import chatsolution.web.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/counseling")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public String chatList(Model model){
        return "chat/chat_room";
    }

    @PostMapping("/send")
    public @ResponseBody String msgSend(@RequestParam("msg") String msg, @RequestParam("time") String time) {
        log.info("전달받은 메세지: " + msg);
        log.info("전달받은 시간: " + time);
        String returnValue = "true";
        return returnValue;
    }
}
