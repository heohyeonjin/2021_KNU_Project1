package chatsolution.web.message.model;

import chatsolution.web.corporation.model.TimeStamped;
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

    @Column(nullable = false)
    private String msgType;     // 메세지 타입

    @Column(nullable = false)
    private int msgStatus;      // 메세지 전송상태
}
