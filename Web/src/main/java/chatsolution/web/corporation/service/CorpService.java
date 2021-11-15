package chatsolution.web.corporation.service;


import chatsolution.web.corporation.dto.CorpListDto;
import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.corporation.repository.CorpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorpService {

    private final CorpRepository corpRepository;
    public List<CorpListDto> corplist(){
       List<Corporation> corp = corpRepository.findAll();
       return corp.stream()
               .map(o -> new CorpListDto(o))
               .collect(Collectors.toList());
    }
}
