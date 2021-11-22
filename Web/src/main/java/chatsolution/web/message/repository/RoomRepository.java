package chatsolution.web.message.repository;

import chatsolution.web.message.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {


    List<Room> findAllByClient_ClientNoOrderByModifiedAtDesc(Long clientNo);
}