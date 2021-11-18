package chatsolution.web.message.service;

import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.message.dto.MessageDto;
import chatsolution.web.message.dto.MessageListDto;
import chatsolution.web.message.dto.NewMessageDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    // 기존에 존재하는 메세지 띄우기
    public List<MessageListDto> msgList(){
        List<Message> existMsg = messageRepository.findAll();
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
