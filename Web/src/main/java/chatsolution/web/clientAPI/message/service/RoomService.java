package chatsolution.web.clientAPI.message.service;


import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    final private RoomRepository roomRepository;

    public Long createRoom(Client client, Counselor counselor){
        Room room = new Room(client,counselor);
        roomRepository.save(room);
        client.getRooms().add(room); // 방 리스트 추가
        return room.getRoomNo();
    }

    @Transactional
    public String msgReadProcess(Room room){
        List<Message> msg = room.getMessages();
        for(int i =0 ;i<msg.size();i++){
            if(msg.get(i).getClientRead()==0){
                msg.get(i).setClientRead(1);
            }
        }
    return "읽음 처리 완료";
    }
}
