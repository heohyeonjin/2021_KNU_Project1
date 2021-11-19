package chatsolution.web.client.controller;

import chatsolution.web.client.dto.IdDoubleCheckDto;
import chatsolution.web.client.dto.SignInRequestDto;
import chatsolution.web.client.dto.SignUpRequestDto;
import chatsolution.web.client.service.ClientAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ClientAPIController {

    private final ClientAPIService clientAPIService;

    // 아이디 중복체크
    @GetMapping("/api/check")
    public String idDoubleCheck(@RequestBody IdDoubleCheckDto idDoubleCheckDto) {
        boolean exist = clientAPIService.idCheck(idDoubleCheckDto);

        if (!exist) return "false";
        return "true";
    }

    // 회원가입
    @PostMapping("/api/signup")
    public String signUp(@RequestBody SignUpRequestDto requestDto){
        String savedClient = clientAPIService.registerClient(requestDto);

        if (!Objects.equals(savedClient, requestDto.getEmail())) {
            return "false";
        }

        return "true";
    }
}
