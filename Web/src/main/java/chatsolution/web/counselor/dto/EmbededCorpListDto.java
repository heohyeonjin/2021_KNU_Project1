package chatsolution.web.counselor.dto;


import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.counselor.model.Counselor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EmbededCorpListDto {
    private Long corpNo;
    private String corpName;

    public EmbededCorpListDto(Corporation corporation){
        this.corpNo = corporation.getCorpNo();
        this.corpName=corporation.getCorpName();
    }


}
