package chatsolution.web.message.service;

import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.message.dto.MessageDto;
import chatsolution.web.message.dto.NewMessageDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;


    public List<MessageDto> updateMessage() {
        List<MessageDto> messages = null;
        MessageDto temp1 = new MessageDto("123");
        log.info(temp1.getMsgContent());
        messages.add(temp1);
        // 디비 확인해서 최근의 메시지 시간보다 이전에 변수로 저장해놓은 메시지 시간이
        // 같으면 false 반환
        // 디비 값 < 변수 시간(최근) --> error
        // 디비 값(최근) > 변수 시간 --> true 반환
        log.info(messages.get(0).getMsgContent());
        return messages;
    }

    // 상담원 메세지 저장
    public boolean saveMsg(NewMessageDto newMessageDto){
            Message newMsg = new Message(newMessageDto);
            messageRepository.save(newMsg);
            log.info("상담원 메세지 저장 성공");
            return true;
    }

}
