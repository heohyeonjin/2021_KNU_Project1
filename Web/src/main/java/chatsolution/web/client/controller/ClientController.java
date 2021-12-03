package chatsolution.web.client.controller;


import chatsolution.web.client.dto.*;
import chatsolution.web.client.model.Client;
import chatsolution.web.client.service.ClientService;
import chatsolution.web.counselor.service.CounselorService;
import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.dto.CorpPages;
import com.google.api.Http;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final CounselorService counselorService;
    // 고객 리스트 페이징
    @GetMapping
    public String clientPaging(@RequestParam(value = "page", defaultValue = "0") int clientPage, Model model, HttpServletRequest request) {
        Long corpNo = counselorService.getCorpNo(request.getSession()); // 기업 정보
        if(corpNo==null) //기업 관리자 권한이 아닌 경우
            corpNo=0L;
        List<ClientListDto> clients = clientService.getClientListPage(clientPage,corpNo);
        ClientPages pages = clientService.getClientPages(clientPage);
        Long auth_classify = counselorService.getAuthClassify(request.getSession()); // 권한 가져오기
        model.addAttribute("clients", clients);
        model.addAttribute("pages", pages);
        model.addAttribute("nav", "client");
        model.addAttribute("auth",auth_classify);
        return "client/client_list";
    }

    // 고객 검색
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam(value = "page", defaultValue = "0") int clientPage, Model model) {
        List<ClientListDto> clients = clientService.search(keyword, clientPage);
        ClientPages pages = clientService.getSearchPages(clientPage, keyword);
        model.addAttribute("clients", clients);
        model.addAttribute("pages", pages);
        model.addAttribute("nav", "client");
        return "client/client_list";
    }

    //고객 상세정보
    @GetMapping("/{clientNo}")
    public String client(@PathVariable long clientNo, Model model, HttpServletRequest request) {
        ClientInfoDto client = clientService.clientInfo(clientNo);
        Long auth_classify = counselorService.getAuthClassify(request.getSession()); // 권한 가져오기
        model.addAttribute("client", client);
        List<ClientCounListDto> counselingList = clientService.counselingList(clientNo);
        model.addAttribute("counList",counselingList);
        model.addAttribute("nav", "client");
        model.addAttribute("auth",auth_classify);
        return "client/client_info";
    }

    //고객 상담내역
    @GetMapping("/counseling/{roomNo}")
    public String counContent(@PathVariable long roomNo, Model model, HttpServletRequest request){
        List<CounContentsDto> counContents = clientService.counContents(roomNo);
        Long auth_classify = counselorService.getAuthClassify(request.getSession()); // 권한 가져오기
        String corpName = clientService.getCorpName(roomNo);
        model.addAttribute("corpName",corpName);
        model.addAttribute("counseling_content",counContents);
        model.addAttribute("nav", "client");
        model.addAttribute("auth",auth_classify);
        return "client/counseling_content";
    }

    // 고객정보 수정 페이지
    @GetMapping("/{clientNo}/edit")
    public String clientEditForm(@PathVariable long clientNo, Model model, HttpServletRequest request){
        ClientInfoDto client = clientService.clientInfo(clientNo);
        Long auth_classify = counselorService.getAuthClassify(request.getSession()); // 권한 가져오기
        model.addAttribute("client", client);
        model.addAttribute("nav", "client");
        model.addAttribute("auth",auth_classify);
        return "client/client_edit";
    }

    // 고객정보 수정
    @PostMapping("/{clientNo}/edit")
    public String clientEdit(@PathVariable long clientNo, ClientEditDto editDto) {
        clientService.updateClient(clientNo, editDto);
        return "redirect:/client/{clientNo}";
    }

}
