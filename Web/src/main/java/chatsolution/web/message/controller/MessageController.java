package chatsolution.web.message.controller;

import chatsolution.web.message.dto.MessageDto;
import chatsolution.web.message.dto.NewMessageDto;
import chatsolution.web.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public @ResponseBody String msgSend(NewMessageDto newMessageDto) {
        log.info("전달받은 메세지: " + newMessageDto.getMsg());
        messageService.saveMsg(newMessageDto);
        String returnValue = "true";
        return returnValue;
    }

    //폴링
    @RequestMapping(value = "/addMessage", method = RequestMethod.GET)
    public String newMessages(Model model){
        log.info("야야");
        List<MessageDto> messages = messageService.updateMessage();
        log.info(messages.get(0).getMsgContent());
        model.addAttribute("myMessageData", messages);
        return "chat/chat_room :: #messageDiv";
    }


}
