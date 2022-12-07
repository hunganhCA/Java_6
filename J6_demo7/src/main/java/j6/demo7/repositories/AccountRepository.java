package j6.demo7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import j6.demo7.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
