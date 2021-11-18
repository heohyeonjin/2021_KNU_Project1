package chatsolution.web.message.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class MessageDto {
    private String msgContent;

    public MessageDto(String msg){
        this.msgContent = msg;
    }
}