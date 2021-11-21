package chatsolution.web.message.dto;

import chatsolution.web.message.model.Message;
import chatsolution.web.message.model.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Slf4j
@Getter @Setter
@NoArgsConstructor
public class RoomListDto {
    private Long roomNo;
    private String name;
    private String content;
    private String time;
    private int sender;

    public RoomListDto(Room room) {
        int size = room.getMessages().size() - 1;
        Message last = room.getMessages().get(size);

        this.roomNo = room.getRoomNo();
        this.name = room.getClient().getClientName();
        this.content = last.getMsgContent();

        // 오늘 날짜 구하기
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowDate = now.format(dateFormatter);

        // 다른 날짜일 경우
        if (!last.getCreatedAt().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE).equals(nowDate)) {
            this.time = last.getCreatedAt().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        else {
            this.time = last.getCreatedAt().getHour() + ":" + last.getCreatedAt().getMinute();
        }
    }
}
