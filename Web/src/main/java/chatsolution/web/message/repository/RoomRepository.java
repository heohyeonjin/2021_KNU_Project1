package chatsolution.web.message.repository;

import chatsolution.web.message.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
