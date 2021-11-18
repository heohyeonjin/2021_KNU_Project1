package chatsolution.web.counselor.service;

import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.counselor.dto.CounListDto;
import chatsolution.web.counselor.model.Counselor;
import chatsolution.web.counselor.repository.CounselorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


}
