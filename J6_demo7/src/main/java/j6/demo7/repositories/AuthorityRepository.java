package j6.demo7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import j6.demo7.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
