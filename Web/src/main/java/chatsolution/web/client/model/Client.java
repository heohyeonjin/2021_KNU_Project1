package chatsolution.web.client.model;

import chatsolution.web.client.dto.SignUpRequestDto;
import chatsolution.web.corporation.model.TimeStamped;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.room.model.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Client extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientNo;          // 고객 일련번호

    @Column(nullable = false)
    private String clientEmail;     // 고객 이메일

    @Column(nullable = false)
    private String clientPw;        // 고객 비밀번호

    @Column(nullable = false)
    private String clientName;      // 고객 이름

    @Column(nullable = false)
    private String clientPhone;     // 고객 전화번호

    @Column(nullable = false)
    private int clientGender;             // 고객 성별

    @OneToMany(mappedBy="client")
    private List<Room> rooms;

    public Client(SignUpRequestDto requestDto) {
        this.clientEmail = requestDto.getEmail();
        this.clientPw = requestDto.getPassword();
        this.clientName = requestDto.getName();
        this.clientPhone = requestDto.getTel();
        this.clientGender = requestDto.getGender();
    }
}
