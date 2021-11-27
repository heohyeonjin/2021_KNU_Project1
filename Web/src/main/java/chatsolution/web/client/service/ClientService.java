package chatsolution.web.client.service;

import chatsolution.web.client.dto.*;
import chatsolution.web.clientAPI.auth.model.Client;
import chatsolution.web.clientAPI.auth.repository.ClientRepository;
import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
private final ClientRepository clientRepository;
private final RoomRepository roomRepository;

    //고객 리스트
    public List<ClientListDto> clientList(){
        List<Client> client = clientRepository.findAll();
        return client.stream()
                .map(ClientListDto::new)
                .collect(Collectors.toList());
    }

    //고객 상세정보
    public ClientInfoDto clientInfo(Long clientNo){
        Optional<Client> findClient = clientRepository.findById(clientNo);
        Client client = findClient.get();
        return new ClientInfoDto(client);
    }

    //고객 상담리스트
    public List<ClientCounListDto> counselingList(Long clientNo){
        Optional<Client> findClient = clientRepository.findById(clientNo);
        Client client = findClient.get();
        List<Room> clientList = client.getRooms();
        return clientList.stream()
                .map(o->new ClientCounListDto(o))
                .collect(Collectors.toList());
    }

    //고객 상담내역
    public List<CounContentsDto> counContents(Long roomNo){
        Optional<Room> findRoom = roomRepository.findById(roomNo);
        Room room = findRoom.get();
        List<Message> messages = room.getMessages();
        return messages.stream()
                .map(o-> new CounContentsDto(o))
                .collect(Collectors.toList());
    }

    //회사 이름
    public String getCorpName(Long roomNo){
        Optional<Room> findRoom = roomRepository.findById(roomNo);
        Room room = findRoom.get();
        String corpName = room.getCounselor().getCorporation().getCorpName();
        return corpName;
    }

    // 고객정보 수정
    @Transactional
    public void updateClient(Long clientNo, ClientEditDto editDto) {
        Client client = clientRepository.findById(clientNo).orElseThrow(
                ()->new NullPointerException("접근 오류"));

        client.setClientStatus(editDto.getClient_status());
    }
}
