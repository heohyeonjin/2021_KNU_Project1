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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String loginRequest(LoginRequestDto requestDto, HttpServletRequest servletRequest){

        // 로그인 권한 체크
        String auth = requestDto.getLogin_radio();
        log.info(requestDto.getLogin_radio());
        Long userNo = authService.loginProcess(requestDto);

        if(auth.equals("login_admin") && userNo != 0L) {
            servletRequest.getSession().setAttribute("adminNo", userNo);
            return "redirect:/corporation";
        }
        else if(auth.equals("login_corp") && userNo != 0L) {
            servletRequest.getSession().setAttribute("corpNo", userNo);
            return "redirect:/counselor";
        }
        else if(auth.equals("login_coun") && userNo != 0L) {
            servletRequest.getSession().setAttribute("counNo", userNo);
            return "redirect:/counseling";
        }
        else {
            // 실패시 alert 띄우기
            return "auth/auth";
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/auth";
    }
}
