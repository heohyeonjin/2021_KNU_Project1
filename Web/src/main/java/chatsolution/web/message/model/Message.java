package chatsolution.web.message.model;

import chatsolution.web.corporation.model.TimeStamped;
import chatsolution.web.message.dto.ClientMessageSendDto;
import chatsolution.web.message.dto.NewMessageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Message extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msgNo;         // 메세지 일련번호

    @Column(nullable = false)
    private String msgContent;  // 메세지 내용

    private int msgType;        // 메세지 타입

    private int msgStatus;      // 메세지 전송상태

    private int msgSender;      // 보낸 사람 (상담원 : 0 고객 : 1)

    private int counRead;       // 상담원 읽음 처리

    private int clientRead;     // 고객 읽음 처리

    private int clientRead;

    private int counRead;

    @ManyToOne
    @JoinColumn
    private Room room;

    public Message(NewMessageDto newMessageDto) {
        this.msgContent = newMessageDto.getMsg();
        this.msgType = newMessageDto.getMsgType();
    }

    // 클라이언트 메시지
    public Message(ClientMessageSendDto clientMessageSendDto, Room room){
        this.msgContent = clientMessageSendDto.getContent();
        this.msgType = clientMessageSendDto.getMsgType();
        this.msgSender = 1;
        this.clientRead=1;
        this.counRead=0;
        this.room = room;
    }
}
