package chatsolution.web.counselor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CounRegDto {
    private String coun_gender;
    private String coun_name;
    private String coun_id;
    private String coun_pw;
    private String coun_phone;
    private String coun_email;
    private String coun_logo;
}
