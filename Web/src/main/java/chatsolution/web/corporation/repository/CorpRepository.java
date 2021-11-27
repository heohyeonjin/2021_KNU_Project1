package chatsolution.web.corporation.repository;

import chatsolution.web.corporation.model.Corporation;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorpRepository extends JpaRepository<Corporation, Long> {
    boolean existsByCorpId(String corp_id);
    Corporation findByCorpId(String id);

    @NotNull
    Page<Corporation> findAll(Pageable pageable);
}
