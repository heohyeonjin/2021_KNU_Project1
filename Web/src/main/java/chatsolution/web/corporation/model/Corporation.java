package chatsolution.web.corporation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Corporation {

    @Id
    @Column(nullable = false)
    private String corp_id;     // 기업 아이디

    @Column(nullable = false)
    private String corp_pw;     // 기업 비밀번호

    private int corp_status;    // 기업 상태

    @Column(nullable = false)
    private String corp_name;   // 기업 이름

    private String corp_admin;  // 기업 대표자

    private String corp_phone;  // 기업 연락처

    private String corp_email;   // 기업 이메일

    private String corp_logo;   // 기업 로고

    private String corp_desc;   // 기업 상세정보

    private LocalDateTime corp_regTime; // 기업 등록일
}
