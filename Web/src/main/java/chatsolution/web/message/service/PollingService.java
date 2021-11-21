package chatsolution.web.message.service;

import chatsolution.web.message.dto.MessageDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.MessageRepository;
import chatsolution.web.message.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PollingService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    // 채팅방 내 마지막 메세지 확인
    public Long checkLast(Long roomNo) {
        Optional<Room> room = roomRepository.findById(roomNo);

        int size = room.get().getMessages().size();
        Message message = room.get().getMessages().get(size - 1);

        return message.getMsgNo();
    }

    // polling 통해 비동기적으로 메세지 띄우기
    public List<MessageDto> updateMessage(Long lastMsg) {
        List<MessageDto> messages = new ArrayList<>();

        // webLastMsg -> Room 정보 찾기
        Optional<Message> webLastMsg = messageRepository.findById(lastMsg);
        Optional<Room> room = roomRepository.findById(webLastMsg.get().getRoom().getRoomNo());

        // webLastMsg vs DBLastMsg
        int size = room.get().getMessages().size();
        Message DBLastMsg = room.get().getMessages().get(size - 1);
        if (DBLastMsg == webLastMsg.get()) {
            return null;
        }

        // webLastMsg idx 파악
        int idx = 0;
        for (int i=0; i<size; i++) {
            if (room.get().getMessages().get(i) == webLastMsg.get()) {
                idx = i;
            }
        }

        // 최신 update 메세지 리스트 저장
        for (int i=idx+1; i<size; i++) {
            MessageDto recent = new MessageDto(room.get().getMessages().get(i));
            messages.add(recent);
        }

        return messages;
    }
}
