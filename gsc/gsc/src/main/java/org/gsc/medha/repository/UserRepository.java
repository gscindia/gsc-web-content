package org.gsc.medha.repository;

import java.util.Optional;

import org.gsc.medha.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
	@Query("SELECT u FROM User u WHERE u.username=?1 and u.password=?2 ")
	User authenticate(String username, String password);

	@Query("SELECT u FROM User u WHERE u.username=?1")
	Optional<User> findByUsername(String username);
}
