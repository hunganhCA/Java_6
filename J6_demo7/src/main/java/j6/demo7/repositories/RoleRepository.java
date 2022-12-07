package j6.demo7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import j6.demo7.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
