package chatsolution.web.message.service;

import chatsolution.web.message.dto.MessageDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PollingService {

    private final MessageRepository messageRepository;

    // polling 통해 비동기적으로 메세지 띄우기
    public List<MessageDto> updateMessage(Long lastMsg) {
        List<MessageDto> messages = new ArrayList<>();

        Message recentMsg = messageRepository.findTopByOrderByMsgNoDesc();
        if (Objects.equals(recentMsg.getMsgNo(), lastMsg)) {
            return null;
        }

        MessageDto recent = new MessageDto(recentMsg);
        messages.add(recent);
        log.info(messages.get(0).getContent());

        //MessageDto temp1 = new MessageDto("123");
        //messages.add(temp1);

        return messages;
    }
}
