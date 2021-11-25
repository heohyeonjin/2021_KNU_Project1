package chatsolution.web.client.controller;


import chatsolution.web.client.dto.ClientCounListDto;
import chatsolution.web.client.dto.ClientInfoDto;
import chatsolution.web.client.dto.ClientListDto;
import chatsolution.web.client.dto.CounContentsDto;
import chatsolution.web.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // 고객 리스트
    @GetMapping
    public String clients(Model model) {
        List<ClientListDto> clients = clientService.clientList();
        log.info(clients.size()+"");
        model.addAttribute("clients", clients);
        return "client/client_list";
    }

    //고객 상세정보
    @GetMapping("/{clientNo}")
    public String client(@PathVariable long clientNo,Model model) {
        ClientInfoDto client = clientService.clientInfo(clientNo);
        model.addAttribute("client", client);
        List<ClientCounListDto> counselingList = clientService.counselingList(clientNo);
        model.addAttribute("counList",counselingList);
        return "client/client_info";
    }
    //고객 상담내역
    @GetMapping("/counseling/{roomNo}")
    public String counContent(@PathVariable long roomNo,Model model){
        List<CounContentsDto> counContents = clientService.counContents(roomNo);
        String corpName = clientService.getCorpName(roomNo);
        model.addAttribute("corpName",corpName);
        model.addAttribute("counseling_content",counContents);
        return "client/counseling_content";
    }

}
