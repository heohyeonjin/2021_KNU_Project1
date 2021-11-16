package chatsolution.web.corporation.dto;


import chatsolution.web.corporation.model.Corporation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
public class CorpListDto {
    private Long corp_no;
    private String corp_name;
    private String corp_phone;
    private String corp_admin;
    private LocalDateTime corp_regTime;
    private String corp_status;

    public CorpListDto(Corporation corporation){
        this.corp_no = corporation.getCorp_no();
        this.corp_name = corporation.getCorp_name();
        this.corp_phone = corporation.getCorp_phone();
        this.corp_admin = corporation.getCorp_admin();
        this.corp_regTime =corporation.getCorp_regTime();
        int corp = corporation.getCorp_status();
        if(corp==1) {
            this.corp_status = "사용 중";
        }
        else if(corp==0){
            this.corp_status ="사용 정지";
        }
        else{
            this.corp_status="확인 불가";
        }

    }

}
