package chatsolution.web.corporation.controller;


import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import chatsolution.web.corporation.service.CorpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/corporation")
@RequiredArgsConstructor
public class CorpController {

    private final CorpRepository corpRepository;
    private final CorpService corpservice;

    @GetMapping
    public String corporation(Model model){
        List<CorpListDto> corps =  corpservice.corplist();
        model.addAttribute("corps",corps);
        return "corporation/corp_list";

    }
}
