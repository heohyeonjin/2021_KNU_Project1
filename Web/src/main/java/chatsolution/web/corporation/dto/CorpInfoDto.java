package chatsolution.web.corporation.dto;

import chatsolution.web.corporation.model.Corporation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class CorpInfoDto {
    private String corp_status; //상태
    private String corp_name; //기업명
    private String corp_admin; //대표자
    private String corp_id; //아이디
    private String corp_phone; //연락처
    private String corp_email;
    private String corp_desc;
    private String corp_logo;


    public CorpInfoDto(Corporation corporation){
       int corp = corporation.getCorp_status();
       this.corp_name = corporation.getCorp_name();
       this.corp_admin = corporation.getCorp_admin();
       this.corp_id = corporation.getCorp_id();
       this.corp_phone = corporation.getCorp_phone();
       this.corp_email = corporation.getCorp_email();
       this.corp_desc = corporation.getCorp_desc();
       this.corp_logo = corporation.getCorp_logo();
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

