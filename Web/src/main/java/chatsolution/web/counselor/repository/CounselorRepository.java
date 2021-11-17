package chatsolution.web.counselor.repository;

import chatsolution.web.counselor.model.Counselor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounselorRepository extends JpaRepository<Counselor, Long> {
    Optional<Counselor> findByCounId(String id);
}
