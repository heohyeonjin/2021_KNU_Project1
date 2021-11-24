package chatsolution.web.clientAPI.message.controller;


import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.clientAPI.message.dto.MessageSendDto;
import chatsolution.web.clientAPI.message.service.ClientMessageService;
import chatsolution.web.clientAPI.message.service.RoomService;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.message.dto.MessageListDto;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientMessageController {

    private final ClientMessageService messageClientService;
    private final RoomService roomClientService;
    private final CorpRepository corpRepository;
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    @GetMapping("/message/{roomNo}") // 채팅 방 안 메시지 내역
    public List<MessageListDto> messageList(@PathVariable Long roomNo){
        List<MessageListDto> messages = messageClientService.messageList(roomNo);
        Optional<Room> findRoom = roomRepository.findById(roomNo);
        Room room = findRoom.get();
        roomService.msgReadProcess(room);
        return messages;
    }

    // 기업 선택 -> 메시지 하나 보내면 방 생성
    @PostMapping("/message/{corpNo}") // 메시지 전송 및 방 생성
    public String sendMsg(@RequestBody MessageSendDto clientMessageSendDto , @PathVariable Long corpNo, HttpServletRequest request){
        Client client = messageClientService.getClient(request.getSession()); //고객 정보
        Long checkRoom = messageClientService.checkRoom(client,corpNo); //방 존재 유무 확인

        if(checkRoom!=0L){ // 존재 하면 // 해당 방 안에 메시지 리스트 추가
            messageClientService.addMessage(checkRoom,clientMessageSendDto);
            log.info(clientMessageSendDto.getContent()+" 메시지 추가");
            return "true";
        }
        else{
            Optional<Corporation> corporation = corpRepository.findById(corpNo);
            Corporation corp = corporation.get();

            if(corp.getCounselors().size()==0){
                return "false";
            }
            Counselor counselor = corp.getCounselors().get(0);
            Long roomNo = roomClientService.createRoom(client, counselor); // 방 생성
            messageClientService.addMessage(roomNo,clientMessageSendDto); // 메시지 추가
            log.info(clientMessageSendDto.getContent()+"방 생성");
            return"true";
        }

    }
}
