package chatsolution.web.message.controller;

import chatsolution.web.message.dto.MessageListDto;
import chatsolution.web.message.dto.NewMessageDto;
import chatsolution.web.message.dto.RoomListDto;
import chatsolution.web.message.service.MessageWebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/counseling")
@RequiredArgsConstructor
public class MessageWebController {

    private final MessageWebService messageWebService;

    // 채팅방 목록
    @GetMapping
    public String roomList(Model model, HttpServletRequest request) {

        Long enter = (Long)request.getSession().getAttribute("counNo");
        log.info("로그인한 상담원 일련번호: " + enter);

        List<RoomListDto> rooms = messageWebService.roomList(enter);
        model.addAttribute("rooms", rooms);
        return "chat/chat_list";
    }

    // 채팅방 입장
    @GetMapping("/{roomNo}")
    public String enterRoom(@PathVariable Long roomNo, Model model, HttpServletRequest request) {

        Long enter = (Long)request.getSession().getAttribute("counNo");
        List<MessageListDto> messages = messageWebService.msgList(enter, roomNo);

        model.addAttribute("messages", messages);
        return "chat/chat_room";
    }

    @PostMapping("/{roomNo}/send")
    public @ResponseBody String msgSend(@PathVariable Long roomNo, NewMessageDto newMessageDto) {
        log.info("전달받은 메세지: " + newMessageDto.getMsg());
        messageWebService.saveMsg(newMessageDto);
        String returnValue = "true";
        return returnValue;
    }

}
