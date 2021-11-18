package chatsolution.web.message.service;

import chatsolution.web.message.dto.NewMessageDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    // 상담원 메세지 저장
    public boolean saveMsg(NewMessageDto newMessageDto) {
        Message newMsg = new Message(newMessageDto);
        messageRepository.save(newMsg);

        log.info("상담원 메세지 저장 성공");
        return true;
    }

}
