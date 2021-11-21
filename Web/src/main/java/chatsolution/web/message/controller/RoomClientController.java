package chatsolution.web.message.controller;


import chatsolution.web.client.model.Client;
import chatsolution.web.message.dto.ClientRoomListDto;
import chatsolution.web.message.model.Room;
import chatsolution.web.message.service.MessageClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RoomClientController {
    private final MessageClientService messageClientService;

    @GetMapping("/api/roomList")
    public List<ClientRoomListDto> roomList(HttpServletRequest request){
        Client client = messageClientService.getClient(request.getSession());
        log.info("룸 리스트 고객: "+client.getClientName());
        List<Room> rooms = client.getRooms();
        log.info("룸 사이즈 : "+ rooms.size()+"룸 정보들 :"+rooms.get(0).getRoomNo());
        return client.getRooms().stream()
                .map(o -> new ClientRoomListDto(o))
                .collect(Collectors.toList());
    }
}
