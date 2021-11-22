package chatsolution.web.clientAPI.message.service;


import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.clientAPI.auth.repository.ClientRepository;
import chatsolution.web.clientAPI.message.dto.MessageSendDto;
import chatsolution.web.message.dto.MessageListDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.MessageRepository;
import chatsolution.web.message.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class ClientMessageService {

    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;
    private final MessageRepository messageRepository;

    // 클라이언트 No 값
    public Client getClient(HttpSession session){
       Long clientNo = (Long) session.getAttribute("clientNo");
       return clientRepository.findByClientNo(clientNo);
    }

    //채팅 리스트
    public List<MessageListDto> messageList(Long roomNo){
        Optional<Room> findroom = roomRepository.findById(roomNo);
        Room room = findroom.get();

        return room.getMessages().stream()
                .map(o-> new MessageListDto(o))
                .collect(Collectors.toList());
    }

    // 방 존재 유무 체크
    public Long checkRoom(Client client, Long corpNo){
        List<Room> room = client.getRooms();

        for(int i =0 ; i<room.size();i++){
           if(room.get(i).getCounselor().getCorporation().getCorpNo()==corpNo){
               room.get(i).getRoomNo();
               return room.get(i).getRoomNo();
           }
        }
        return 0L;
    }

    // 메시지 추가
    public String addMessage(Long roomNo, MessageSendDto clientMessageSendDto){
        Optional<Room> findRoom = roomRepository.findById(roomNo);
        Room room = findRoom.get();

        Message newMsg = new Message(clientMessageSendDto, room);
        messageRepository.save(newMsg);
        room.getMessages().add(newMsg);

        return newMsg.getMsgContent();
    }
}
