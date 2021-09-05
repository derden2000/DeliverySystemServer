package ru.antonshu.couriersystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.antonshu.couriersystem.entities.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findOneByTitle(String title);
}
