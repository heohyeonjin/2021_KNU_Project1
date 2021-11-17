package chatsolution.web.corporation.repository;

import chatsolution.web.corporation.model.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorpRepository extends JpaRepository<Corporation, Long> {
    boolean existsByCorpId(String corp_id);
    Optional<Corporation> findByCorpId(String id);
}
