package pro.antonshu.couriersystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.antonshu.couriersystem.entities.Role;
import pro.antonshu.couriersystem.entities.Wallet;


@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {

//    Role findOneByTitle(String title);
}
