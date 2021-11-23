package chatsolution.web.message.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class NewMessageDto {
    private String msg;
    private int msgType;
    private Long sender;
    private Long roomInfo;
}
