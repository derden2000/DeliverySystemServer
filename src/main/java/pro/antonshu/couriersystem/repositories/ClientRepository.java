package pro.antonshu.couriersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.antonshu.couriersystem.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findOneByPhone(String phone);

    Client findOneById(Long id);

    boolean existsByPhone(String phone);
}
