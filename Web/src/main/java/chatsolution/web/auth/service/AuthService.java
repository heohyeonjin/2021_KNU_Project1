package chatsolution.web.auth.service;

import chatsolution.web.auth.dto.LoginRequestDto;
import chatsolution.web.auth.model.Admin;
import chatsolution.web.auth.repository.AuthRepository;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.counselor.repository.CounselorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final CorpRepository corpRepository;
    private final CounselorRepository counselorRepository;

    public boolean loginProcess(LoginRequestDto requestDto) {
        String id = requestDto.getId();
        String pw = requestDto.getPw();
        String auth = requestDto.getAuth();

        if (auth.equals("login_admin")) {
            log.info("admin 성공");
            Optional<Admin> find = authRepository.findById(id);
            //log.info(find.get().getAdmin_id());
            return find.isPresent() && find.get().getAdmin_pw().equals(pw);
        }
        else if (auth.equals("login_corp")) {
            log.info("corporation 성공");
            Optional<Corporation> find = corpRepository.findByCorpId(id);
            //log.info(find.get().getCorpId());
            return find.isPresent() && find.get().getCorpPw().equals(pw);
        }
        else if (auth.equals("login_coun")) {
            log.info("counselor 성공");
            Optional<Counselor> find = counselorRepository.findByCounId(id);
            //log.info(find.get().getCounId());
            return find.isPresent() && find.get().getCounPw().equals(pw);
        }

        log.info("로그인 실패");
        return false;
    }
}
