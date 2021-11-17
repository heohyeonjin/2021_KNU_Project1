package chatsolution.web.auth.controller;

import chatsolution.web.auth.dto.LoginRequestDto;
import chatsolution.web.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 로그인 화면
    @GetMapping
    public String loginView() {
        return "auth/auth";
    }

    // 로그인 결과
    @PostMapping
    public String loginRequest(@RequestParam String login_id, @RequestParam String login_pw, @RequestParam String login_radio){

        LoginRequestDto requestDto = new LoginRequestDto(login_id, login_pw, login_radio);
        boolean result = authService.loginProcess(requestDto);

        log.info(login_radio);
        log.info(String.valueOf(result));
        if(login_radio.equals("login_admin") && result) {
            return "redirect:/corporation";
        }
        else if(login_radio.equals("login_corp") && result) {
            return "redirect:/counselor";
        }
        else if(login_radio.equals("login_coun") && result) {
            return "redirect:/counseling";
        }
        else {
            return "auth/auth";
        }

    }
}
