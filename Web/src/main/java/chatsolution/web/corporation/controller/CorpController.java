package chatsolution.web.corporation.controller;


import chatsolution.web.corporation.dto.CorpEditDto;
import chatsolution.web.corporation.dto.CorpInfoDto;
import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.dto.CorpRegDto;
import chatsolution.web.corporation.service.CorpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/corporation")
@RequiredArgsConstructor
public class CorpController {

    private final CorpService corpservice;

    @GetMapping
    public String corporations(Model model) {
        List<CorpListDto> corps = corpservice.corplist();
        model.addAttribute("corps", corps);
        return "corporation/corp_list";

    }

    @GetMapping("/add")
    public String addCorpForm() {
        return "corporation/corp_new";
    }

    @PostMapping("/add")
    public String addCorp(@ModelAttribute("corpReg") CorpRegDto corpRegDto, Model model) {
        log.info(corpRegDto.getCorp_name());

        CorpInfoDto newCorp = corpservice.saveCorp(corpRegDto);
        model.addAttribute("corp", newCorp);
        return "redirect:/corporation/" + newCorp.getCorp_no();
    }

    @GetMapping("/{corpId}")
    public String corporation(@PathVariable long corpId, Model model) {
        CorpInfoDto corp = corpservice.corpinfo(corpId);
        model.addAttribute("corp", corp);
        return "corporation/corp_info";
    }

    @PostMapping("/idCheck")
    public @ResponseBody boolean idCheck(@RequestParam("id") String id) {
        log.info("아이디 중복체크 - 전달받은 id: " + id);
        boolean corpIdCheck = corpservice.idCheck(id);
        log.info("아이디 중복체크 - id 확인결과: " + corpIdCheck);
        return corpIdCheck;
    }
    @GetMapping("/{corpId}/edit")
    public String editForm(@PathVariable Long corpId, Model model){
        CorpInfoDto corp = corpservice.corpinfo(corpId);
        model.addAttribute("corp",corp);
        return "corporation/corp_edit";
    }
    @PostMapping("/{corpId}/edit")
    public String edit(@PathVariable Long corpId, @ModelAttribute("corp") CorpEditDto corpEditDto){
        corpservice.updateCorp(corpId,corpEditDto);
        return "redirect:/corporation/{corpId}";
    }
}
