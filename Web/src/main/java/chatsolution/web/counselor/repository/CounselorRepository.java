package chatsolution.web.counselor.repository;

import chatsolution.web.corporation.model.Corporation;
import chatsolution.web.counselor.model.Counselor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounselorRepository extends JpaRepository<Counselor, Long> {
    Counselor findByCounId(String id);
    boolean existsByCounId(String corp_id);

    @NotNull
    Page<Counselor> findAll(Pageable pageable);
}
