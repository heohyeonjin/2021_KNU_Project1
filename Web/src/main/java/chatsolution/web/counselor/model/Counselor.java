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
    private Long counNo;       // 상담원 일련번호

    @Column(nullable = false)
    private String counId;     // 상담원 아이디

    @Column(nullable = false)
    private String counPw;     // 상담원 비밀번호

    @Column(nullable = false)
    private int counStatus;    // 상담원 상태

    @Column(nullable = false)
    private int counCorp;      // 상담원 소속

    @Column(nullable = false)
    private String counName;   // 상담원 이름

    private String counPhone;  // 상담원 연락처

    private String counEmail;  // 상담원 이메일

    private String counImage;  // 상담원 사진

    private int counGender;    // 상담원 성별

}
