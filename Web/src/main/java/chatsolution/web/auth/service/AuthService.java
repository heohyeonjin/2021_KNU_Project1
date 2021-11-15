package chatsolution.web.auth.service;

import chatsolution.web.auth.dto.LoginRequestDto;
import chatsolution.web.auth.model.Admin;
import chatsolution.web.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public boolean loginProcess(LoginRequestDto requestDto) {
        String id = requestDto.getId();
        String pw = requestDto.getPw();
        String auth = requestDto.getAuth();

        if (auth.equals("login_admin")) {
            log.info("admin 성공");
            Optional<Admin> find = authRepository.findById(id);
            log.info(find.get().getAdmin_id());
            return find.isPresent() && find.get().getAdmin_pw().equals(pw);
        }
        log.info("admin 실패");
        return false;
    }
}
