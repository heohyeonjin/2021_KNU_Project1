package chatsolution.web.counselor.controller;

import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.counselor.dto.CounListDto;
import chatsolution.web.counselor.dto.CounRegDto;
import chatsolution.web.counselor.dto.EmbededCorpListDto;
import chatsolution.web.counselor.service.CounselorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/counselor")
@RequiredArgsConstructor
public class CounselorController {

    private final CounselorService counselorService;

    // 상담원 리스트
    @GetMapping
    public String counselors(Model model) {
        List<CounListDto> couns = counselorService.counList();
        model.addAttribute("couns", couns);
        return "counselor/coun_list";
    }

    // 상담원 등록 페이지
    @GetMapping("/add")
    public String addCounselorForm(Model model) {
        List<EmbededCorpListDto> EmbededCorp = counselorService.corpList();
        model.addAttribute("corps", EmbededCorp);
        return "counselor/coun_new";
    }

    //아이디 중복체크
    @PostMapping("/idCheck")
    public @ResponseBody boolean idCheck(@RequestParam("id") String id) {
        log.info("아이디 중복체크 - 전달받은 id: " + id);
        boolean counIdCheck = counselorService.idCheck(id);
        log.info("아이디 중복체크 - id 확인결과: " + counIdCheck);
        return counIdCheck;
    }

    // 상담원 등록
    @PostMapping("/add")
    public String addCounselor(@ModelAttribute("counsReg") CounRegDto counRegDto) {
        log.info(counRegDto.getEmbeded_corp()+"corp");
        log.info(counRegDto.getCoun_id());
        log.info(counRegDto.getCoun_gender()+"gender");
        counselorService.saveCoun(counRegDto);
        return "redirect:/counselor";
    }
}
