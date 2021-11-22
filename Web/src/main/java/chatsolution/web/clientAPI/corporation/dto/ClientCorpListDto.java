package chatsolution.web.clientAPI.corporation.dto;

import chatsolution.web.corporation.model.Corporation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClientCorpListDto {
    private String corpName;
    private String corpAdmin;

    public ClientCorpListDto(Corporation corporation){
        this.corpName = corporation.getCorpName();
        this.corpAdmin = corporation.getCorpAdmin();
    }
}
