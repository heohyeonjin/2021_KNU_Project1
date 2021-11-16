package chatsolution.web.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Admin {

    @Id
    @Column(nullable = false)
    private String admin_id;

    @Column(nullable = false)
    private String admin_pw;
}
