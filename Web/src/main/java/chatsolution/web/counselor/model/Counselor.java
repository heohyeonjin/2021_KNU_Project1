package chatsolution.web.counselor.model;

import chatsolution.web.corporation.model.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Counselor extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coun_no;       // 상담원 일련번호

    @Column(nullable = false)
    private String coun_id;     // 상담원 아이디

    @Column(nullable = false)
    private String coun_pw;     // 상담원 비밀번호

    @Column(nullable = false)
    private int coun_status;    // 상담원 상태

    @Column(nullable = false)
    private int coun_corp;      // 상담원 소속

    @Column(nullable = false)
    private String coun_name;   // 상담원 이름

    private String coun_phone;  // 상담원 연락처

    private String coun_email;  // 상담원 이메일

    private String coun_image;  // 상담원 사진

    private int coun_gender;    // 상담원 성별

    private LocalDateTime coun_regTime; // 상담원 등록일

}
