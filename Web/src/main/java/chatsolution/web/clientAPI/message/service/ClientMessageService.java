package chatsolution.web.clientAPI.message.service;


import chatsolution.web.client.model.Client;
import chatsolution.web.client.repository.ClientRepository;
import chatsolution.web.clientAPI.message.dto.MessageSendDto;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.counselor.repository.CounselorRepository;
import chatsolution.web.message.dto.MessageListDto;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.MessageRepository;
import chatsolution.web.message.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
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
    private final CorpRepository corpRepository;
    private final CounselorRepository counselorRepository;

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


    // 메시지 추가
    @Transactional
    public String addMessage(Long roomNo, MessageSendDto clientMessageSendDto){
        Optional<Room> findRoom = roomRepository.findById(roomNo);
        Room room = findRoom.get();
        Message newMsg = new Message(clientMessageSendDto, room);
        messageRepository.save(newMsg);
        room.getMessages().add(newMsg);
        room.setMsgSize(room.getMsgSize()+1);
        return newMsg.getMsgContent();
    }

    // 메시지 읽음 처리
    @Transactional
    public void msgReadProcess(Room room){
        List<Message> msg = room.getMessages();
        for(int i =0 ;i<msg.size();i++){
            if(msg.get(i).getClientRead()==0){
                msg.get(i).setClientRead(1);
            }
        }
    }

    //토큰 저장
    @Transactional
    public void saveToken(Client client, String token){
        client.setFcmToken(token);

    }


    // 방 존재 유무 체크
    public Long checkRoom(Client client, Long corpNo){
        List<Room> room = client.getRooms();
        for(int i =0 ; i<room.size();i++){
            if(corpNo==room.get(i).getCounselor().getCorporation().getCorpNo()){
                room.get(i).getRoomNo();
                return room.get(i).getRoomNo();
            }
        }
        return 0L;
    }

    // 회사 이름 가져오기
    public String getCorpName(Long corpNo){
        Optional<Corporation> findCorp = corpRepository.findById(corpNo);
        Corporation corp = findCorp.get();
        return corp.getCorpName();
    }

    // 상담원 매칭 시스템
    public Counselor CounselorMatching(Long corpNo){
        List<Counselor> counselors = counselorRepository.findAllByCorporationCorpNoOrderByRoomSizeAsc(corpNo);
        for(int i = 0 ;i<counselors.size();i++){
            log.info(counselors.get(i).getCounName()+"의 상담 고객 수:"+counselors.get(i).getRooms().size());
            log.info(counselors.get(i).getCounName()+"의 방 사이즈:"+counselors.get(i).getRoomSize());
        }
        Counselor matchCoun = counselors.get(0);
        log.info("매칭된 상담원 :"+matchCoun.getCounName());
        return matchCoun;
    }
}
