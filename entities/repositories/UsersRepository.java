package br.com.imepac.site.entities.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imepac.site.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);
}
