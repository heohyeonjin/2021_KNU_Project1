package chatsolution.web.counselor.controller;

import chatsolution.web.counselor.dto.CounListDto;
import chatsolution.web.counselor.dto.CounRegDto;
import chatsolution.web.counselor.service.CounselorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/counselor")
@RequiredArgsConstructor
public class CounselorController {

    private final CounselorService counselorService;

    // 상담원 리스트
    @GetMapping
    public String counselors(Model model){
        List<CounListDto> couns = counselorService.counList();
        model.addAttribute("couns", couns);
        return "counselor/coun_list";
    }

    // 상담원 등록 페이지
    @GetMapping("/add")
    public String addCounselorForm(Model model) {
        return "counselor/coun_new";
    }

    // 상담원 등록
//    @PostMapping("/add")
//    public String addCounselor(CounRegDto Model model) {
//
//    }
}
