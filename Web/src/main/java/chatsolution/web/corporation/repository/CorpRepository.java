package chatsolution.web.corporation.repository;

import chatsolution.web.corporation.model.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpRepository extends JpaRepository<Corporation, String> {

}
