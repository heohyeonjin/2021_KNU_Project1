package chatsolution.web.corporation.service;


import chatsolution.web.corporation.dto.CorpEditDto;
import chatsolution.web.corporation.dto.CorpInfoDto;
import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.dto.CorpRegDto;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CorpService {

    private final CorpRepository corpRepository;

    //기업 리스트
    public List<CorpListDto> corplist(){
       List<Corporation> corp = corpRepository.findAll();
       return corp.stream()
               .map(o -> new CorpListDto(o))
               .collect(Collectors.toList());
    }

    //기업 상세정보
    public CorpInfoDto corpinfo(Long corpId){
        Corporation corp = corpRepository.findById(corpId).orElseThrow(
                ()->new NullPointerException("접근 오류"));
        log.info(corp.getCorpName());
        return new CorpInfoDto(corp);
    }

    //기업 등록
    public void saveCorp(CorpRegDto corpRegDto) {
        Corporation newCorp = new Corporation(corpRegDto);
        corpRepository.save(newCorp);
    }

    //기업 수정
    @Transactional
    public void updateCorp(Long corpId, CorpEditDto corpEditDto){
        Corporation corp = corpRepository.findById(corpId).orElseThrow(
                ()->new NullPointerException("접근 오류"));
        log.info(corpEditDto.getCorp_name());
        corp.setCorpStatus(corpEditDto.getCorp_status());
        corp.setCorpName(corpEditDto.getCorp_name());
        log.info(corp.getCorpName());
        corp.setCorpAdmin(corpEditDto.getCorp_admin());
        corp.setCorpPhone(corpEditDto.getCorp_phone());
        corp.setCorpEmail(corpEditDto.getCorp_email());
        corp.setCorpDesc(corpEditDto.getCorp_desc());
    }

}
