package chatsolution.web.message.dto;


import chatsolution.web.message.model.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClientMessageSendDto {

    private String content; // 메시지 내용
    private int msgType; // 메시지 타입
    private int Sender; //보낸 사람
    private int clientRead;
    private int counRead;
}
