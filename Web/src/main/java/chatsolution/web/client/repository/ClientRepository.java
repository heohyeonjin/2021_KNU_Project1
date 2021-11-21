package chatsolution.web.client.repository;

import chatsolution.web.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByClientEmail(String email);
    Client findByClientNo(Long clientNo);
}
