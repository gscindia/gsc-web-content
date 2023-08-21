package org.gsc.medha.repository;

import org.gsc.medha.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.id=?1 and u.password=?2 ")
	public User authenticate(String id, String password);
}
