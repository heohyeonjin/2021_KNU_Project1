package chatsolution.web.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LoginRequestDto {
    private String id;
    private String pw;
    private String auth;

    public LoginRequestDto(String id, String pw, String auth){
        this.id = id;
        this.pw = pw;
        this.auth = auth;
    }
}