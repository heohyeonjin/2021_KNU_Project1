package chatsolution.web.counselor.service;

import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.counselor.dto.CounEditDto;
import chatsolution.web.counselor.dto.CounInfoDto;
import chatsolution.web.counselor.dto.CounListDto;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.counselor.repository.CounselorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounselorService {

    private final CounselorRepository counselorRepository;

    // 상담원 리스트
    public List<CounListDto> counList(){
        List<Counselor> couns = counselorRepository.findAll();
        return couns.stream()
                .map(o -> new CounListDto(o))
                .collect(Collectors.toList());
    }

    // 상담원 상세정보
    public CounInfoDto counInfo(Long counNo) {
        Counselor coun = counselorRepository.findById(counNo).orElseThrow(
                ()->new NullPointerException("접근 오류"));
        log.info(coun.getCounName());
        return new CounInfoDto(coun);
    }

    // 상담원 수정
    @Transactional
    public void updateCoun(Long counNo, CounEditDto editDto) {
        Counselor coun = counselorRepository.findById(counNo).orElseThrow(
                ()->new NullPointerException("접근 오류"));
        log.info("찾은 상담원 ID: " + coun.getCounNo());

        coun.setCounStatus(editDto.getCounStatus());
        coun.setCounName(editDto.getCounName());
        coun.setCounGender(editDto.getCounGender());
        coun.setCounPhone(editDto.getCounPhone());
        coun.setCounEmail(editDto.getCounEmail());
        coun.setCounImage(editDto.getCounImage());
    }

}
