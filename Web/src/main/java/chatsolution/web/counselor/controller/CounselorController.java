package chatsolution.web.counselor.controller;

import chatsolution.web.counselor.dto.CounEditDto;
import chatsolution.web.counselor.dto.CounInfoDto;
import chatsolution.web.counselor.dto.CounListDto;
import chatsolution.web.counselor.dto.CounRegDto;
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

    // 상담원 정보 조회
    @GetMapping("/{counNo}")
    public String counselor(@PathVariable long counNo, Model model) {
        CounInfoDto coun = counselorService.counInfo(counNo);
        model.addAttribute("coun", coun);
        return "counselor/coun_info";
    }

    // 상담원 정보 수정 페이지
    @GetMapping("/{counNo}/edit")
    public String editForm(@PathVariable Long counNo, Model model) {
        CounInfoDto coun = counselorService.counInfo(counNo);
        model.addAttribute("coun", coun);
        return "counselor/coun_edit";
    }

    // 상담원 정보 수정
    @PostMapping("/{counNo}/edit")
    public String edit(@PathVariable Long counNo, @ModelAttribute("coun") CounEditDto editDto) {
        counselorService.updateCoun(counNo, editDto);
        return "redirect:/counselor/{counNo}";
    }
}
