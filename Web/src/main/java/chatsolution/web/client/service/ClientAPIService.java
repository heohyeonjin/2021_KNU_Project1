package chatsolution.web.client.service;

import chatsolution.web.client.dto.IdDoubleCheckDto;
import chatsolution.web.client.dto.SignInRequestDto;
import chatsolution.web.client.dto.SignUpRequestDto;
import chatsolution.web.client.model.Client;
import chatsolution.web.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientAPIService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    // 아이디 중복체크
    public boolean idCheck(IdDoubleCheckDto idDoubleCheckDto) {

        String requestId = idDoubleCheckDto.getEmail();
        Client exist = clientRepository.findByClientEmail(requestId);

        // 존재하면 false
        return exist.getClientEmail() == null;
    }

    // 회원가입
    public String registerClient(SignUpRequestDto requestDto) {

        // 패스워드 암호화
        String encoding = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(encoding);

        Client newClient = new Client(requestDto);
        clientRepository.save(newClient);

        return newClient.getClientEmail();
    }

    //로그인
    public Client loginClient(SignInRequestDto signInRequestDto){
        Client client = null;
        String ClientEmail = signInRequestDto.getEmail();
        Client findClient = clientRepository.findByClientEmail(ClientEmail);

        if(findClient!=null) {
            if (passwordEncoder.matches(signInRequestDto.getPassword(), findClient.getClientPw())) {
                client = findClient;
            }
            return client;
        }
        return client;
    }
}
