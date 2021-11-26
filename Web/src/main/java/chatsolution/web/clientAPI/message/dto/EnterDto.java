package chatsolution.web.clientAPI.message.dto;

public class EnterDto {
    private Long roomNo;
    private String corpName;

    public EnterDto(Long roomNo, String corpName){
        this.roomNo = roomNo;
        this.corpName = corpName;
    }
}
