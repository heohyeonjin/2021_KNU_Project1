package chatsolution.web.corporation.controller;


import chatsolution.web.corporation.dto.CorpInfoDto;
import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.dto.CorpRegDto;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import chatsolution.web.corporation.service.CorpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/corporation")
@RequiredArgsConstructor
public class CorpController {

    private final CorpRepository corpRepository;
    private final CorpService corpservice;

    @GetMapping
    public String corporations(Model model){
        List<CorpListDto> corps =  corpservice.corplist();
        model.addAttribute("corps",corps);
        return "corporation/corp_list";

    }

    @GetMapping("/add")
    public String addCorpForm() {
        return "corporation/corp_new";
    }

    @PostMapping("/add")
    public String addCorp(@ModelAttribute("corpReg") CorpRegDto corpRegDto){
        log.info(corpRegDto.getCorp_name());

        corpservice.saveCorp(corpRegDto);
        return "corporation/corp_info";
    }
  
    @GetMapping("/{corpId}")
    public String corporation(@PathVariable long corpId, Model model){
        CorpInfoDto corp = corpservice.corpinfo(corpId);
        model.addAttribute("corp",corp);
        return "corporation/corp_info";
}
