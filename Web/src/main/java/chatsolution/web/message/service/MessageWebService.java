package chatsolution.web.message.service;

import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.counselor.repository.CounselorRepository;
import chatsolution.web.message.dto.MessageListDto;
import chatsolution.web.message.dto.NewMessageDto;
import chatsolution.web.message.dto.RoomListDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageWebService {

    private final CounselorRepository counselorRepository;
    private final MessageRepository messageRepository;

    // 채팅방 리스트 띄우기
    public List<RoomListDto> roomList(Long counNo){

        Optional<Counselor> coun = counselorRepository.findById(counNo);
        if (coun.isEmpty()) return null;

        List<Room> existRoom = coun.get().getRooms();
        return existRoom.stream()
                .map(o -> new RoomListDto(o))
                .collect(Collectors.toList());
    }

    // 채팅방 내 존재하는 메세지 띄우기
    public List<MessageListDto> msgList(Long counNo, Long roomNo){

        // 먼저 counNo로 counselor 찾기 -> counselor room에서 roomNo 찾기
        Optional<Counselor> coun = counselorRepository.findById(counNo);
        if (coun.isEmpty()) return null;

        Room room = new Room();
        List<Room> rooms = coun.get().getRooms();
        for (Room value : rooms) {
            if (value.getRoomNo() == roomNo)
                room = value;
        }
        
        List<Message> existMsg = room.getMessages();
        return existMsg.stream()
                .map(o -> new MessageListDto(o))
                .collect(Collectors.toList());
    }

    // 상담원이 전송한 메세지 저장
    public boolean saveMsg(NewMessageDto newMessageDto) {
        Message newMsg = new Message(newMessageDto);
        messageRepository.save(newMsg);

        log.info("상담원 메세지 저장 성공");
        return true;
    }
}
