package chatsolution.web.message.controller;

import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.fcm.service.FirebaseCloudMessageService;
import chatsolution.web.message.dto.*;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.service.MessageWebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/counseling")
@RequiredArgsConstructor
public class MessageWebController {

    private final MessageWebService messageWebService;
    private final FirebaseCloudMessageService fcmService;

    // 채팅방 목록
    @GetMapping
    public String roomList(Model model, HttpServletRequest request) {

        Long enter = (Long)request.getSession().getAttribute("counNo");

        Optional<Counselor> counselor = messageWebService.getCounName(enter);
        List<RoomListDto> rooms = messageWebService.roomList(enter);
        model.addAttribute("counNo", enter);
        model.addAttribute("counName", counselor.get().getCounName());
        model.addAttribute("rooms", rooms);
        return "chat/chat_list";
    }

    // 채팅방 입장
    @GetMapping("/{roomNo}")
    public String enterRoom(@PathVariable Long roomNo, Model model, HttpServletRequest request) {

        Long enter = (Long)request.getSession().getAttribute("counNo");
        RoomInfoDto info = messageWebService.getRoomInfo(roomNo);
        List<MessageListDto> messages = messageWebService.msgList(enter, roomNo);

        model.addAttribute("info", info);
        model.addAttribute("messages", messages);
        return "chat/chat_room";
    }

    // web에서 메세지 전송
    @PostMapping("/{roomNo}/send")
    public @ResponseBody String msgSend(@PathVariable Long roomNo, NewMessageDto newMessageDto) throws IOException {
        log.info("전달받은 메세지: " + newMessageDto.getMsg());
        messageWebService.saveMsg(newMessageDto, roomNo);
        // token, title, content
        Room room = messageWebService.getRoom(roomNo);
        Client client = room.getClient();
        String token = client.getFcmToken(); // 클라이언트 토큰 값
        Corporation corporation = room.getCounselor().getCorporation(); String title = corporation.getCorpName(); // 기업 이름
        fcmService.sendMessageTo(token,title,newMessageDto.getMsg());
        return "success";
    }

}
