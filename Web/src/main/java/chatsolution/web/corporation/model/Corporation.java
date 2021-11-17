package chatsolution.web.corporation.model;

import chatsolution.web.corporation.dto.CorpRegDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Corporation extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long corpNo;       // 기업 일련번호

    @Column(nullable = false)
    private String corpId;     // 기업 아이디

    @Column(nullable = false)
    private String corpPw;     // 기업 비밀번호

    private int corpStatus;    // 기업 상태

    @Column(nullable = false)
    private String corpName;   // 기업 이름

    private String corpAdmin;  // 기업 대표자

    private String corpPhone;  // 기업 연락처

    private String corpEmail;   // 기업 이메일

    private String corpLogo;   // 기업 로고

    private String corpDesc;   // 기업 상세정보

    public Corporation(CorpRegDto corpRegDto) {
        this.corpId = corpRegDto.getCorp_id();
        this.corpPw = corpRegDto.getCorp_pw();
        this.corpName = corpRegDto.getCorp_name();
        this.corpAdmin = corpRegDto.getCorp_admin();
        this.corpPhone = corpRegDto.getCorp_phone();
        this.corpEmail = corpRegDto.getCorp_email();
        this.corpLogo = corpRegDto.getCorp_logo();
        this.corpDesc = corpRegDto.getCorp_descrip();

        this.corpStatus = 1;
    }
}
