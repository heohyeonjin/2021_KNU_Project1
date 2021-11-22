package chatsolution.web.clientAPI.auth.repository;

import chatsolution.web.clientAPI.auth.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByClientEmail(String email);
    Client findByClientNo(Long clientNo);
}
