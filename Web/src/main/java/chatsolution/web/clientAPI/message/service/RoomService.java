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
import java.util.Optional;

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


    public Room findRoom(Long roomNo){
        Optional<Room> findRoom = roomRepository.findById(roomNo);
        Room room = findRoom.get();
        return room;
    }
}
