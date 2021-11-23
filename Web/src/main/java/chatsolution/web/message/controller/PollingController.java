package chatsolution.web.message.controller;

import chatsolution.web.message.dto.MessageDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.repository.MessageRepository;
import chatsolution.web.message.service.PollingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/poll")
@RequiredArgsConstructor
public class PollingController {

    private final PollingService pollingService;
    private final MessageRepository messageRepository;

    //폴링
    @GetMapping
    public @ResponseBody List<MessageDto> newMessages(@RequestParam("lastMsg") Long lastMsg){
        List<MessageDto> messages = pollingService.updateMessage(lastMsg);
        return messages;
    }

    // 마지막 메세지
    @GetMapping("/lastMsg")
    public @ResponseBody Long checkLast() {
        Message last = messageRepository.findTopByOrderByMsgNoDesc();
        return last.getMsgNo();
    }
}
